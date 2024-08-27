package com.powernode.mall.service.impl;

import com.powernode.mall.mapper.TCommentMapper;
import com.powernode.mall.po.TComment;
import com.powernode.mall.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private TCommentMapper commentMapper;


    @Override
    public int addComment(TComment comment) {
        commentMapper.insert(comment);
        return comment.getCid();
    }

    @Override
    public void removeComment(Integer commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public void updateComment(TComment comment) {
        commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public TComment getComment(Integer commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }

}
