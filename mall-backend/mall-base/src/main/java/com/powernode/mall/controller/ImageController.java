package com.powernode.mall.controller;

import com.powernode.mall.po.TImage;
import com.powernode.mall.service.IImageService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("image")
public class ImageController extends BaseController{
    @Autowired
    private IImageService imageService;

    @RequestMapping("add")
    public JsonResult<?> addImage(TImage image){
        imageService.addImage(image);
        return new JsonResult<>(OK);
    }

    @RequestMapping("remove")
    public JsonResult<?> removeImage(Integer iid){
        imageService.removeImage(iid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<?> updateImage(TImage image){
        imageService.updateImage(image);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get")
    public JsonResult<?> getImage(Integer iid){
        TImage image = imageService.getImage(iid);
        return new JsonResult<>(OK, image);
    }

    @RequestMapping("removeByPid")
    public JsonResult<?> removeImageByPid(Integer pid){
        imageService.removeImageByPid(pid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("getByPid")
    public JsonResult<?> getImageByPid(Integer pid){
        ArrayList<TImage> images = imageService.getImageByPid(pid);
        return new JsonResult<>(OK, images);
    }

    @RequestMapping("getBySid")
    public JsonResult<?> getImageBySid(Integer sid){
        ArrayList<TImage> images = imageService.getImageByPid(sid);
        return new JsonResult<>(OK, images);
    }
}
