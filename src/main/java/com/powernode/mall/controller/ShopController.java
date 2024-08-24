package com.powernode.mall.controller;

import com.powernode.mall.dto.Product;
import com.powernode.mall.dto.Shop;
import com.powernode.mall.dto.ShopInfo;
import com.powernode.mall.service.IShopService;
import com.powernode.mall.util.JsonResult;
import com.powernode.mall.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("shop")
@CrossOrigin(origins="*")
public class ShopController extends BaseController {

    @Autowired
    IShopService shopService;

    @RequestMapping("get_products")
    public JsonResult<?> getProducts(Integer sid) {
        ArrayList<Product> products = shopService.getAllProducts(sid);
        return new JsonResult<>(OK, products);
    }

    @RequestMapping("search")
    public JsonResult<?> search(String keywords) {
        ArrayList<Shop> shops = shopService.getShopByKeywords(keywords);
        return new JsonResult<>(OK, shops);
    }

    @RequestMapping("shop_info")
    public JsonResult<?> getShopInfo(Integer sid) {
        ShopInfo shopInfo = shopService.getShopInfoBySid(sid);
        return new JsonResult<>(OK, shopInfo);
    }

    @RequestMapping("get_sid")
    public JsonResult<?> getShopSid(String username) {
        int sid = shopService.getSidByUsername(username);
        return new JsonResult<>(OK, sid);
    }
}
