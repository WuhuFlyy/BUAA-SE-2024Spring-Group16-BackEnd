package com.powernode.mall.controller;


import com.powernode.mall.po.TComment;
import com.powernode.mall.service.ICommentService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.powernode.mall.controller.BaseController.OK;

@RestController
@RequestMapping("comment")
public class CommentController extends BaseController{
    @Autowired
    private ICommentService commentService;

    @RequestMapping("add")
    public JsonResult<Integer> addComment(@RequestBody TComment comment) {
        int cid = commentService.addComment(comment);
        return new JsonResult<>(OK,cid);
    }

    @RequestMapping("remove")
    public JsonResult<Void> removeComment(@RequestParam Integer commentId) {
        commentService.removeComment(commentId);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<Void> updateComment(@RequestBody TComment comment) {
        commentService.updateComment(comment);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get")
    public JsonResult<TComment> getComment(@RequestParam Integer commentId) {
        TComment comment = commentService.getComment(commentId);
        return new JsonResult<>(OK, comment);
    }

    @RequestMapping("getByPid")
    public JsonResult<ArrayList<TComment>> getCommentByPid(@RequestParam Integer pid) {
        ArrayList<TComment> comments = commentService.getCommentByPid(pid);
        return new JsonResult<>(OK, comments);
    }


}