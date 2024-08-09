package com.powernode.mall.mapper;

import com.powernode.mall.po.Comment;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Comment row);

    Comment selectByPrimaryKey(Integer cid);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment row);
}