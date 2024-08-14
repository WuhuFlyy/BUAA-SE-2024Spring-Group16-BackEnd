package com.powernode.mall.controller;

import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.service.IShopService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("shop")
public class ShopController extends BaseController {

    @Autowired
    IShopService shopService;

    @RequestMapping("get_products")
    public JsonResult<?> getProducts(Integer sid) {
        ArrayList<ShopItem> shopItems = shopService .getAllProducts(sid);
        return new JsonResult<>(OK, shopItems);
    }
}
