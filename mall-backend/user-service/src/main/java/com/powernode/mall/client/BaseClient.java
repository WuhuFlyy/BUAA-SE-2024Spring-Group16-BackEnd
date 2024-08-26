package com.powernode.mall.client;


import com.powernode.mall.po.TComment;
import com.powernode.mall.po.TCommentImage;
import com.powernode.mall.po.TShop;
import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

import static com.powernode.mall.controller.BaseController.OK;

@FeignClient(name = "shop-service", url = "http://localhost:8888")
public interface BaseClient {

    @RequestMapping("/shop/insert_shop")
    public JsonResult<?> insertShop(@RequestBody TShop shop);

    @RequestMapping("/shop/get_shop_by_sid")
    public JsonResult<?> getShopInfoBySid(@RequestParam("sid") Integer sid);



    @RequestMapping("/comment/add")
    public JsonResult<Void> addComment(@RequestBody TComment comment);

    @RequestMapping("/comment/remove")
    public JsonResult<Void> removeComment(@RequestParam Integer commentId);

    @RequestMapping("/comment/update")
    public JsonResult<Void> updateComment(@RequestBody TComment comment);

    @RequestMapping("/comment/get")
    public JsonResult<?> getComment(@RequestParam Integer commentId);



    @RequestMapping("/commentimage/add")
    public JsonResult<Void> addCommentImage(@RequestBody TCommentImage commentImage);

    @RequestMapping("/commentimage/remove")
    public JsonResult<Void> removeCommentImage(@RequestParam Integer commentImageId);

    @RequestMapping("/commentimage/update")
    public JsonResult<Void> updateCommentImage(@RequestBody TCommentImage commentImage);

    @RequestMapping("/commentimage/get")
    public JsonResult<?> getCommentImage(@RequestParam Integer commentImageId);

}
