package com.powernode.mall.mapper;

import com.powernode.mall.po.FavoriteProduct;
import java.util.List;

public interface FavoriteProductMapper {
    int deleteByPrimaryKey(Integer fpid);

    int insert(FavoriteProduct row);

    FavoriteProduct selectByPrimaryKey(Integer fpid);

    List<FavoriteProduct> selectAll();

    int updateByPrimaryKey(FavoriteProduct row);
}