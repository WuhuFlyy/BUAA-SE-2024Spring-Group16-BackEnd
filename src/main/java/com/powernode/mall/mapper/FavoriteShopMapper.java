package com.powernode.mall.mapper;

import com.powernode.mall.po.FavoriteShop;
import java.util.List;

public interface FavoriteShopMapper {
    int deleteByPrimaryKey(Integer fsid);

    int insert(FavoriteShop row);

    FavoriteShop selectByPrimaryKey(Integer fsid);

    List<FavoriteShop> selectAll();

    int updateByPrimaryKey(FavoriteShop row);
}