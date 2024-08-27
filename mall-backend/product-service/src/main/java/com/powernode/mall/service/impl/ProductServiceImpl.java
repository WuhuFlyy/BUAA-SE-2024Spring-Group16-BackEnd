package com.powernode.mall.service.impl;

import com.powernode.mall.client.BaseClient;
import com.powernode.mall.client.UserClient;
import com.powernode.mall.dto.Comment;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.mapper.TProductMapper;
import com.powernode.mall.po.*;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.service.ex.InsertException;
import com.powernode.mall.service.ex.ProductNoMatchingShopException;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private BaseClient baseClient;
    @Autowired
    private UserClient userClient;

//    @Autowired
//    private TCommentMapper commentMapper;
//
//    @Autowired
//    private TShopMapper shopMapper;
//
//    @Autowired
//    private TVersionMapper versionMapper;
//
//    @Autowired
//    private TImageMapper imageMapper;
//
//    @Autowired
//    private TUserMapper userMapper;

    @Override
    public TProduct selectByPrimaryKey(Integer id) {
        TProduct tProduct = productMapper.selectByPrimaryKey(id);
        if (tProduct == null) {
            throw new ProductNotFoundException("查询商品不存在");
        }

        tProduct.setPriority(null);
        tProduct.setCreatedUser(null);
        tProduct.setCreatedTime(null);
        tProduct.setModifiedUser(null);
        tProduct.setModifiedTime(null);
        return tProduct;
    }

    @Override
    public ProductDetails getProductDetailByProductId(Integer id) {
        TProduct tProduct = productMapper.selectByPrimaryKey(id);
        if (tProduct == null) {
            throw new ProductNotFoundException("查询商品不存在");
        }

        //ArrayList<TComment> tComments = commentMapper.selectByPid(id);
        ArrayList<TComment> tComments = (ArrayList<TComment>) baseClient.getCommentByPid(id).getData();
        ArrayList<TVersion> tVersions = versionMapper.selectByPid(id);

        ArrayList<TImage> tImages = imageMapper.selectByPid(id);

        //TShop tShop = shopMapper.selectByPrimaryKey(tProduct.getSid());
        TShop tShop = (TShop) baseClient.getShopBySid(tProduct.getSid()).getData();
        if (tShop == null) {
            throw new ProductNoMatchingShopException("商品无对应商店");
        }

        ProductDetails productDetails = new ProductDetails();
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> versions = new ArrayList<>();

        if (tComments != null) {
            for (TComment tComment : tComments) {
                comments.add(new Comment(
                        //userMapper.selectByPrimaryKey(tComment.getUid()).getUsername(),
                        userClient.getByUid(tComment.getUid()).getData().getUsername(),
                        tComment.getContent(),
                        tComment.getRate())
                );
            }
        }


        for (TVersion tVersion : tVersions) {
            versions.add(tVersion.getVersion());
        }

        for (TImage tImage : tImages) {
            images.add(tImage.getImageSrc());
        }

        productDetails.setName(tProduct.getProductName());
        productDetails.setPrice(tProduct.getPrice());
        productDetails.setDetails(tProduct.getDetails());
        productDetails.setStorage(tProduct.getStorage());
        productDetails.setShopId(tProduct.getSid());
        productDetails.setShopName(tShop.getShopname());
        productDetails.setComments(comments);
        productDetails.setVersion(versions);
        productDetails.setImageSrc(images);

        return productDetails;
    }

    @Override
    public List<ProductNoDetails> getAllProducts() {
        List<TProduct> tProducts = productMapper.selectAll();
        List<ProductNoDetails> productNoDetails = new ArrayList<>();
        for (TProduct tProduct : tProducts) {
            productNoDetails.add(new ProductNoDetails(
                    tProduct.getPid(),
                    tProduct.getProductName(),
                    tProduct.getImage(),
                    tProduct.getPrice()
            ));
        }
        return productNoDetails;
    }


    @Override
    public ArrayList<ShopItem> getProductByKeywords(String keywords) {
        ArrayList<ShopItem> shopItems = new ArrayList<>();

        System.out.println(keywords);
        ArrayList<TProduct> tProducts = productMapper.selectByKeywords(keywords);

        for (TProduct tProduct : tProducts) {
            shopItems.add(new ShopItem(
                    tProduct.getPid(),
                    tProduct.getProductName(),
                    tProduct.getPrice(),
                    imageMapper.selectByPid(tProduct.getPid()).get(0).getImageSrc()
            ));
        }
        return shopItems;
    }

    @Override
    public void insertProduct(ProductDetails product) {
        TProduct tProduct = new TProduct();
        Date date = new Date();
        String username = shopMapper.selectByPrimaryKey(product.getShopId()).getUsername();
        ArrayList<String> versions = product.getVersion();
        ArrayList<String> images = product.getImageSrc();

        tProduct.setCreatedTime(date);
        tProduct.setModifiedTime(date);
        tProduct.setCreatedUser(username);
        tProduct.setModifiedUser(username);
        tProduct.setPrice(product.getPrice());
        tProduct.setDetails(product.getDetails());
        tProduct.setStorage(product.getStorage());
        tProduct.setSid(product.getShopId());
        tProduct.setStatus(1);
        tProduct.setProductName(product.getName());

        int row = productMapper.insert(tProduct);
        if (row != 1) {
            throw new InsertException("插入数据时发生数据库错误");
        }

        int pid = tProduct.getPid();
        for(String version : versions) {
            TVersion tVersion = new TVersion();
            tVersion.setPid(pid);
            tVersion.setVersion(version);
            versionMapper.insert(tVersion);
        }

        for(String image : images) {
            TImage tImage = new TImage();
            tImage.setPid(pid);
            tImage.setImageSrc(image);
            imageMapper.insert(tImage);
        }

    }

    @Override
    public void updateProduct(ProductDetails product) {
        TProduct oldProduct = productMapper.selectByPrimaryKey(product.getProductId());
        if(oldProduct == null) {
            throw new ProductNotFoundException("商品不存在");
        }

        TProduct tProduct = new TProduct();
        Date date = new Date();
        String username = shopMapper.selectByPrimaryKey(product.getShopId()).getUsername();
        ArrayList<String> versions = product.getVersion();
        ArrayList<String> images = product.getImageSrc();

        tProduct.setModifiedTime(date);
        tProduct.setModifiedUser(username);
        tProduct.setPid(product.getProductId());
        tProduct.setPrice(product.getPrice());
        tProduct.setDetails(product.getDetails());
        tProduct.setStorage(product.getStorage());
        tProduct.setSid(product.getShopId());
        tProduct.setStatus(1);
        tProduct.setProductName(product.getName());

        int row = productMapper.updateByPrimaryKey(tProduct);
        if (row != 1) {
            throw new UpdateException("更新时发生数据库错误");
        }

        int pid = tProduct.getPid();

        versionMapper.deleteByPid(pid);
        imageMapper.deleteByPid(pid);

        for(String version : versions) {
            TVersion tVersion = new TVersion();
            tVersion.setPid(pid);
            tVersion.setVersion(version);
            versionMapper.insert(tVersion);
        }

        for(String image : images) {
            TImage tImage = new TImage();
            tImage.setPid(pid);
            tImage.setImageSrc(image);
            imageMapper.insert(tImage);
        }

    }
}
