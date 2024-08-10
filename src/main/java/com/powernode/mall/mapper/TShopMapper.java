package com.powernode.mall.mapper;

import com.powernode.mall.po.TShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TShopMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(TShop row);

    TShop selectByPrimaryKey(Integer sid);

    List<TShop> selectAll();

    int updateByPrimaryKey(TShop row);
}