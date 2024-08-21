package com.powernode.mall.mapper;

import com.powernode.mall.po.TCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCartMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TCart row);

    TCart selectByPrimaryKey(Integer cid);

    List<TCart> selectAll();

    int updateByPrimaryKey(TCart row);
}