package com.powernode.mall.mapper;

import com.powernode.mall.po.TComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TCommentMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TComment row);

    TComment selectByPrimaryKey(Integer cid);

    List<TComment> selectAll();

    ArrayList<TComment> selectByPid(Integer pid);

    int updateByPrimaryKey(TComment row);
}