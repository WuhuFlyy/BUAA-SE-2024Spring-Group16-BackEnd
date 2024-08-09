package com.powernode.mall.mapper;

import com.powernode.mall.po.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User row);

    User selectByPrimaryKey(Integer uid);

    List<User> selectAll();

    int updateByPrimaryKey(User row);
}