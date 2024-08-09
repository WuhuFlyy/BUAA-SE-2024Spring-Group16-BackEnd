package com.powernode.mall.mapper;

import com.powernode.mall.po.Product;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Product row);

    Product selectByPrimaryKey(Integer pid);

    List<Product> selectAll();

    int updateByPrimaryKey(Product row);
}