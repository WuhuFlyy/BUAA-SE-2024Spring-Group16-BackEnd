package com.powernode.mall.client;


import com.powernode.mall.po.TShop;
import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "mall")
public interface BaseClient {

    @RequestMapping("/shop/insert_shop")
    public JsonResult<?> insertShop(@RequestBody TShop shop);

    @RequestMapping("/shop/get_shop_by_sid")
    public JsonResult<?> getShopInfoBySid(@RequestParam("sid") Integer sid);
}
