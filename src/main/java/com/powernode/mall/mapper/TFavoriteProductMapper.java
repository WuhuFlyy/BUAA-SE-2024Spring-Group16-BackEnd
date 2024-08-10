package com.powernode.mall.mapper;

import com.powernode.mall.po.TFavoriteProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TFavoriteProductMapper {
    int deleteByPrimaryKey(Integer fpid);

    int insert(TFavoriteProduct row);

    TFavoriteProduct selectByPrimaryKey(Integer fpid);

    List<TFavoriteProduct> selectAll();

    int updateByPrimaryKey(TFavoriteProduct row);
}