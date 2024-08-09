package com.powernode.mall.mapper;

import com.powernode.mall.po.Image;
import java.util.List;

public interface ImageMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Image row);

    Image selectByPrimaryKey(Integer iid);

    List<Image> selectAll();

    int updateByPrimaryKey(Image row);
}