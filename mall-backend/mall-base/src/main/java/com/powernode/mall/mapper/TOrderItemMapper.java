package com.powernode.mall.mapper;

import com.powernode.mall.po.TOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TOrderItemMapper {
    int deleteByPrimaryKey(Integer oiid);

    int insert(TOrderItem row);

    TOrderItem selectByPrimaryKey(Integer oiid);

    List<TOrderItem> selectAll();

    int updateByPrimaryKey(TOrderItem row);
}