package com.powernode.mall.service.impl;

import com.powernode.mall.po.TCommentImage;
import com.powernode.mall.service.ICommentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.powernode.mall.mapper.TCommentImageMapper;

import java.util.List;

@Service
public class CommentImageServiceImpl implements ICommentImageService {
    @Autowired
    private TCommentImageMapper commentImageMapper;

    @Override
    public void addCommentImage(TCommentImage commentImage) {
        commentImageMapper.insert(commentImage);
    }

    @Override
    public void removeCommentImage(Integer commentImageId) {
        commentImageMapper.deleteByPrimaryKey(commentImageId);
    }

    @Override
    public void updateCommentImage(TCommentImage commentImage) {
        commentImageMapper.updateByPrimaryKey(commentImage);
    }

    @Override
    public TCommentImage getCommentImage(Integer commentImageId) {
        return commentImageMapper.selectByPrimaryKey(commentImageId);
    }

}