package com.powernode.mall.mapper;

import com.powernode.mall.po.TProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TProductMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(TProduct row);

    TProduct selectByPrimaryKey(Integer pid);

    ArrayList<TProduct> selectBySid(Integer sid);

    List<TProduct> selectAll();

    int updateByPrimaryKey(TProduct row);

}