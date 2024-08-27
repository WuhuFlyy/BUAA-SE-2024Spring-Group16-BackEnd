package com.powernode.mall.client;


import com.powernode.mall.po.TComment;
import com.powernode.mall.po.TCommentImage;
import com.powernode.mall.po.TShop;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shop-service", url = "http://localhost:8888")
public interface BaseClient {

    @RequestMapping("/shop/insert_shop")
    public JsonResult<?> insertShop(@RequestBody TShop shop);

    @RequestMapping("/shop/get_shop_by_sid")
    public JsonResult<?> getShopBySid(@RequestParam("sid") Integer sid);



    @RequestMapping("/comment/add")
    public JsonResult<?> addComment(@RequestBody TComment comment);

    @RequestMapping("/comment/remove")
    public JsonResult<Void> removeComment(@RequestParam Integer commentId);

    @RequestMapping("/comment/update")
    public JsonResult<Void> updateComment(@RequestBody TComment comment);

    @RequestMapping("/comment/get")
    public JsonResult<?> getComment(@RequestParam Integer commentId);

    @RequestMapping("/comment/getByPid")
    public JsonResult<?> getCommentByPid(@RequestParam Integer pid);



    @RequestMapping("/commentimage/add")
    public JsonResult<Void> addCommentImage(@RequestBody TCommentImage commentImage);

    @RequestMapping("/commentimage/remove")
    public JsonResult<Void> removeCommentImage(@RequestParam Integer commentImageId);

    @RequestMapping("/commentimage/update")
    public JsonResult<Void> updateCommentImage(@RequestBody TCommentImage commentImage);

    @RequestMapping("/commentimage/get")
    public JsonResult<?> getCommentImage(@RequestParam Integer commentImageId);

}
