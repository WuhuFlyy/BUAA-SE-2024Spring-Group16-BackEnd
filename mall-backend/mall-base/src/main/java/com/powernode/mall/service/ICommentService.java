package com.powernode.mall.service;

import com.powernode.mall.po.TComment;

import java.util.ArrayList;

public interface ICommentService {

    int addComment(TComment comment);

    void removeComment(Integer commentId);

    void updateComment(TComment comment);

    TComment getComment(Integer commentId);

    ArrayList<TComment> getCommentByPid(Integer pid);

}
