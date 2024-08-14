package com.powernode.mall.service.impl;

import com.powernode.mall.entity.Comment;
import com.powernode.mall.entity.Product;
import com.powernode.mall.entity.ProductDetails;
import com.powernode.mall.entity.ShopItem;
import com.powernode.mall.mapper.*;
import com.powernode.mall.po.*;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.service.ex.ProductNoMatchingShopException;
import com.powernode.mall.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private TCommentMapper commentMapper;

    @Autowired
    private TShopMapper shopMapper;

    @Autowired
    private TVersionMapper versionMapper;

    @Autowired
    private TImageMapper imageMapper;

    @Autowired
    private TUserMapper userMapper;

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

        ArrayList<TComment> tComments = commentMapper.selectByPid(id);
        ArrayList<TVersion> tVersions = versionMapper.selectByPid(id);
        ArrayList<TImage> tImages = imageMapper.selectByPid(id);
        TShop tShop = shopMapper.selectByPrimaryKey(tProduct.getSid());
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
                        userMapper.selectByPrimaryKey(tComment.getUid()).getUsername(),
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
}
