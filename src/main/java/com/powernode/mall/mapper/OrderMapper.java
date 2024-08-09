package com.powernode.mall.mapper;

import com.powernode.mall.po.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Order row);

    Order selectByPrimaryKey(Integer oid);

    List<Order> selectAll();

    int updateByPrimaryKey(Order row);
}