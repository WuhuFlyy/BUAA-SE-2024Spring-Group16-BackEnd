package com.powernode.mall.mapper;

import com.powernode.mall.po.TShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TShopMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(TShop row);

    TShop selectByPrimaryKey(Integer sid);

    ArrayList<TShop> selectByKeywords(String keywords);

    Integer getSaleCountBySid(Integer sid);

    List<TShop> selectAll();

    int updateByPrimaryKey(TShop row);

    void incrementFansNumber(Integer shopId);

    void decrementFansNumber(Integer shopId);
}