package com.powernode.mall.mapper;

import com.powernode.mall.po.TCommentImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCommentImageMapper {
    int deleteByPrimaryKey(Integer ciid);

    int insert(TCommentImage row);

    TCommentImage selectByPrimaryKey(Integer ciid);

    List<TCommentImage> selectAll();

    int updateByPrimaryKey(TCommentImage row);
}