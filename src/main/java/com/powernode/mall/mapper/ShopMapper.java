package com.powernode.mall.mapper;

import com.powernode.mall.po.Shop;
import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Shop row);

    Shop selectByPrimaryKey(Integer sid);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop row);
}