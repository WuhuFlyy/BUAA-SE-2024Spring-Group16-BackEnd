package com.powernode.mall.service.impl;

import com.powernode.mall.client.ProductClient;
import com.powernode.mall.client.UserClient;
import com.powernode.mall.mapper.TFavoriteShopMapper;
import com.powernode.mall.mapper.TShopMapper;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.po.TFavoriteShop;
import com.powernode.mall.po.TShop;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.IFavoriteShopService;
import com.powernode.mall.service.ex.ShopNotFoundException;
import com.powernode.mall.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FavoriteShopServiceImpl implements IFavoriteShopService {
    @Autowired
    private TFavoriteShopMapper favoriteShopMapper;

//    @Autowired
//    private TUserMapper userMapper;

    @Autowired
    private TShopMapper shopMapper;

    @Autowired
    private UserClient userClient;

    @Override
    public void addFavoriteShop(String username, Integer shopId) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        TShop shop = shopMapper.selectByPrimaryKey(shopId);
        if (shop == null) {
            throw new ShopNotFoundException("店铺不存在");
        }

        TFavoriteShop favoriteShop = new TFavoriteShop();
        favoriteShop.setUid(user.getUid());
        favoriteShop.setSid(shopId);
        favoriteShop.setCreatedUser(username);
        favoriteShop.setCreatedTime(new Date());
        favoriteShop.setModifiedUser(username);
        favoriteShop.setModifiedTime(new Date());

        favoriteShopMapper.insert(favoriteShop);
        shopMapper.incrementFansNumber(shopId);
    }

    @Override
    public void removeFavoriteShop(String username, Integer shopId) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        TShop shop = shopMapper.selectByPrimaryKey(shopId);
        if (shop == null) {
            throw new ShopNotFoundException("店铺不存在");
        }

        favoriteShopMapper.deleteByUidAndShopId(user.getUid(), shopId);
        shopMapper.decrementFansNumber(shopId);
    }

    @Override
    public boolean isFavoriteShop(String username, Integer sid) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        TFavoriteShop favoriteShop = favoriteShopMapper.selectByUidAndShopId(user.getUid(), sid);
        return favoriteShop != null;
    }
}