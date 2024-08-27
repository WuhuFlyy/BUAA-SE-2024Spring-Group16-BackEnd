package com.powernode.mall.client;


import com.powernode.mall.po.*;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient(name = "shop-service", url = "http://localhost:8888")
public interface BaseClient {

    @RequestMapping("/shop/insert_shop")
    public JsonResult<?> insertShop(@RequestBody TShop shop);

    @RequestMapping("/shop/get_shop_by_sid")
    public JsonResult<TShop> getShopBySid(@RequestParam("sid") Integer sid);



    @RequestMapping("/comment/add")
    public JsonResult<?> addComment(@RequestBody TComment comment);

    @RequestMapping("/comment/remove")
    public JsonResult<Void> removeComment(@RequestParam Integer commentId);

    @RequestMapping("/comment/update")
    public JsonResult<Void> updateComment(@RequestBody TComment comment);

    @RequestMapping("/comment/get")
    public JsonResult<TComment> getComment(@RequestParam Integer commentId);

    @RequestMapping("/comment/getByPid")
    public JsonResult<ArrayList<TComment>> getCommentByPid(@RequestParam Integer pid);



    @RequestMapping("/commentimage/add")
    public JsonResult<Void> addCommentImage(@RequestBody TCommentImage commentImage);

    @RequestMapping("/commentimage/remove")
    public JsonResult<Void> removeCommentImage(@RequestParam Integer commentImageId);

    @RequestMapping("/commentimage/update")
    public JsonResult<Void> updateCommentImage(@RequestBody TCommentImage commentImage);

    @RequestMapping("/commentimage/get")
    public JsonResult<?> getCommentImage(@RequestParam Integer commentImageId);

    @RequestMapping("/version/add")
    public JsonResult<?> addVersion(@RequestParam TVersion version);

    @RequestMapping("/version/remove")
    public JsonResult<?> removeVersion(@RequestParam Integer vid);

    @RequestMapping("/version/update")
    public JsonResult<?> updateVersion(@RequestParam TVersion version);

    @RequestMapping("/version/get")
    public JsonResult<?> getVersion(@RequestParam Integer vid);

    @RequestMapping("/version/getByPid")
    public JsonResult<?> getVersionByPid(@RequestParam Integer pid);

    @RequestMapping("/version/removeByPid")
    public JsonResult<?> removeByPid(@RequestParam Integer pid);

    @RequestMapping("/image/add")
    public JsonResult<?> addImage(TImage image);

    @RequestMapping("/image/remove")
    public JsonResult<?> removeImage(Integer iid);

    @RequestMapping("/image/update")
    public JsonResult<?> updateImage(TImage image);

    @RequestMapping("/image/get")
    public JsonResult<?> getImage(Integer iid);

    @RequestMapping("/image/removeByPid")
    public JsonResult<?> removeImageByPid(Integer pid);

    @RequestMapping("/image/getByPid")
    public JsonResult<?> getImageByPid(Integer pid);

    @RequestMapping("/image/getBySid")
    public JsonResult<?> getImageBySid(Integer sid);

}
