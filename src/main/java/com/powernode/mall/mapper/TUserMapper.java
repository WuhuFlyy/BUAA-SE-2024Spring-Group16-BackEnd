package com.powernode.mall.mapper;

import com.powernode.mall.po.TUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TUser row);

    TUser selectByPrimaryKey(Integer uid);

    TUser selectByUsername(String username);

    List<TUser> selectAll();

    int updateByPrimaryKey(TUser row);
}