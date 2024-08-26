package com.powernode.mall.client;

import com.powernode.mall.po.TShop;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface ShopClient {

    @RequestMapping("get_products")
    public JsonResult<?> getProducts(@RequestParam("sid") Integer sid);




}
