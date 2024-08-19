package com.powernode.mall.mapper;

import com.powernode.mall.po.TFavoriteShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface TFavoriteShopMapper {
    int deleteByPrimaryKey(Integer fsid);

    int insert(TFavoriteShop row);

    TFavoriteShop selectByPrimaryKey(Integer fsid);

    List<TFavoriteShop> selectAll();

    int updateByPrimaryKey(TFavoriteShop row);

    void deleteByUidAndShopId(Integer uid, Integer sid);

    TFavoriteShop selectByUidAndShopId(Integer uid, Integer sid);
}