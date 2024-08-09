package com.powernode.mall.mapper;

import com.powernode.mall.po.Address;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Address row);

    Address selectByPrimaryKey(Integer aid);

    List<Address> selectAll();

    int updateByPrimaryKey(Address row);
}