package com.powernode.mall.controller;

import com.powernode.mall.po.TCommentImage;
import com.powernode.mall.service.ICommentImageService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.powernode.mall.controller.BaseController.OK;

@RestController
@RequestMapping("commentimage")
public class CommentImageController {
    @Autowired
    private ICommentImageService commentImageService;

    @PostMapping("add")
    public JsonResult<Void> addCommentImage(@RequestBody TCommentImage commentImage) {
        commentImageService.addCommentImage(commentImage);
        return new JsonResult<>(OK);
    }

    @DeleteMapping("remove")
    public JsonResult<Void> removeCommentImage(@RequestParam Integer commentImageId) {
        commentImageService.removeCommentImage(commentImageId);
        return new JsonResult<>(OK);
    }

    @PutMapping("update")
    public JsonResult<Void> updateCommentImage(@RequestBody TCommentImage commentImage) {
        commentImageService.updateCommentImage(commentImage);
        return new JsonResult<>(OK);
    }

    @GetMapping("get")
    public JsonResult<TCommentImage> getCommentImage(@RequestParam Integer commentImageId) {
        TCommentImage commentImage = commentImageService.getCommentImage(commentImageId);
        return new JsonResult<>(OK, commentImage);
    }


}