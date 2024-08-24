package com.powernode.mall.mapper;

import com.powernode.mall.po.TAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TAddressMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(TAddress row);

    TAddress selectByPrimaryKey(Integer aid);

    ArrayList<TAddress> selectByUid(Integer uid);

    List<TAddress> selectAll();

    int updateByPrimaryKey(TAddress row);
}