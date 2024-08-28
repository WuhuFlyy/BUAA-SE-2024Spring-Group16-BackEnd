package com.powernode.mall.service.impl;

import com.powernode.mall.client.ProductClient;
import com.powernode.mall.client.UserClient;
import com.powernode.mall.mapper.TFavoriteProductMapper;
import com.powernode.mall.mapper.TProductMapper;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.po.TFavoriteProduct;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.IFavoriteProductService;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FavoriteProductServiceImpl implements IFavoriteProductService {
    @Autowired
    private TFavoriteProductMapper favoriteProductMapper;

//    @Autowired
//    private TUserMapper userMapper;
//
//    @Autowired
//    private TProductMapper productMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public void addFavoriteProduct(String username, Integer pid) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        //TProduct product = productMapper.selectByPrimaryKey(pid);
        TProduct product = productClient.getByPid(pid).getData();
        if (product == null) {
            throw new ProductNotFoundException("商品不存在");
        }
        TFavoriteProduct favoriteProduct = new TFavoriteProduct();
        favoriteProduct.setUid(user.getUid());
        favoriteProduct.setPid(pid);
        favoriteProduct.setCreatedUser(username);
        favoriteProduct.setCreatedTime(new Date());
        favoriteProduct.setModifiedUser(username);
        favoriteProduct.setModifiedTime(new Date());

        favoriteProductMapper.insert(favoriteProduct);
    }

    @Override
    public void removeFavoriteProduct(String username, Integer pid) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        favoriteProductMapper.deleteByUidAndPid(user.getUid(), pid);
    }

    @Override
    public boolean isFavoriteProduct(String username, Integer pid) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        TFavoriteProduct favoriteProduct = favoriteProductMapper.selectByUidAndPid(user.getUid(), pid);
        return favoriteProduct != null;
    }
}