package com.powernode.mall.controller;

import com.powernode.mall.po.TImage;
import com.powernode.mall.service.IImageService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("image")
public class ImageController extends BaseController{
    @Autowired
    private IImageService imageService;

    @RequestMapping("add")
    public JsonResult<?> addImage(@RequestParam TImage image){
        imageService.addImage(image);
        return new JsonResult<>(OK);
    }

    @RequestMapping("remove")
    public JsonResult<?> removeImage(@RequestParam Integer iid){
        imageService.removeImage(iid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<?> updateImage(@RequestParam TImage image){
        imageService.updateImage(image);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get")
    public JsonResult<TImage> getImage(@RequestParam Integer iid){
        TImage image = imageService.getImage(iid);
        return new JsonResult<>(OK, image);
    }

    @RequestMapping("removeByPid")
    public JsonResult<?> removeImageByPid(@RequestParam Integer pid){
        imageService.removeImageByPid(pid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("getByPid")
    public JsonResult<ArrayList<TImage>> getImageByPid(@RequestParam Integer pid){
        ArrayList<TImage> images = imageService.getImageByPid(pid);
        return new JsonResult<>(OK, images);
    }

    @RequestMapping("getBySid")
    public JsonResult<ArrayList<TImage>> getImageBySid(@RequestParam Integer sid){
        ArrayList<TImage> images = imageService.getImageByPid(sid);
        return new JsonResult<>(OK, images);
    }
}
