package com.powernode.mall.mapper;

import com.powernode.mall.po.Version;
import java.util.List;

public interface VersionMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(Version row);

    Version selectByPrimaryKey(Integer vid);

    List<Version> selectAll();

    int updateByPrimaryKey(Version row);
}