package com.powernode.mall.mapper;

import com.powernode.mall.po.Cart;
import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Cart row);

    Cart selectByPrimaryKey(Integer cid);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart row);
}