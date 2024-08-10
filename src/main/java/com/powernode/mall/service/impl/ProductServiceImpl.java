package com.powernode.mall.service.impl;

import com.powernode.mall.entity.Comment;
import com.powernode.mall.entity.Product;
import com.powernode.mall.mapper.*;
import com.powernode.mall.po.*;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if(tProduct == null){
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
    public Product getProductDetailByProductId(Integer id){
        TProduct tProduct = productMapper.selectByPrimaryKey(id);
        ArrayList<TComment> tComments = commentMapper.selectByPid(id);
        ArrayList<TVersion> tVersions = versionMapper.selectByPid(id);
        ArrayList<TImage> tImages = imageMapper.selectByPid(id);
        TShop tShop = shopMapper.selectByPrimaryKey(tProduct.getSid());
        Product product = new Product();
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> versions = new ArrayList<>();

        for(TComment tComment : tComments){
            comments.add(new Comment(
                    userMapper.selectByPrimaryKey(tComment.getUid()).getUsername(),
                    tComment.getContent(),
                    tComment.getRate())
            );
        }

        for(TVersion tVersion : tVersions){
            versions.add(tVersion.getVersion());
        }

        for(TImage tImage : tImages){
            images.add(tImage.getImageSrc());
        }

        product.setName(tProduct.getProductName());
        product.setPrice(tProduct.getPrice());
        product.setDetails(tProduct.getDetails());
        product.setStorage(tProduct.getStorage());
        product.setShopId(tProduct.getSid());
        product.setShopName(tShop.getShopname());
        product.setComments(comments);
        product.setVersion(versions);
        product.setImageSrc(images);

        return product;
    }
}
