package com.powernode.mall.client;


import com.powernode.mall.po.TShop;
import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient("mall")
public interface BaseClient {

    @RequestMapping("/shop/insert_shop")
    public JsonResult<?> insertShop(@RequestParam("shop") TShop shop);
}
