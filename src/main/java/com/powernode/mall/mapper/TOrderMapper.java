package com.powernode.mall.mapper;

import com.powernode.mall.po.TOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(TOrder row);

    TOrder selectByPrimaryKey(Integer oid);

    List<TOrder> selectAll();

    int updateByPrimaryKey(TOrder row);
}