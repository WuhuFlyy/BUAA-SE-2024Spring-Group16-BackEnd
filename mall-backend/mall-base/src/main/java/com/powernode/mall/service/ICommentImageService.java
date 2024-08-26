package com.powernode.mall.service;

import com.powernode.mall.po.TCommentImage;

import java.util.List;

public interface ICommentImageService {
    void addCommentImage(TCommentImage commentImage);
    void removeCommentImage(Integer commentImageId);
    void updateCommentImage(TCommentImage commentImage);
    TCommentImage getCommentImage(Integer commentImageId);
}