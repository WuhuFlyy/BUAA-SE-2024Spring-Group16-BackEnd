package com.powernode.mall.mapper;

import com.powernode.mall.po.TVersion;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TVersionMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(TVersion row);

    TVersion selectByPrimaryKey(Integer vid);
    ArrayList<TVersion> selectByPid(Integer pid);

    List<TVersion> selectAll();

    int updateByPrimaryKey(TVersion row);
}