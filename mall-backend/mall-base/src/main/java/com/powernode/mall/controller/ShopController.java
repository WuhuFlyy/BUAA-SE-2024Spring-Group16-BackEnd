package com.powernode.mall.controller;

import com.powernode.mall.dto.Product;
import com.powernode.mall.dto.Shop;
import com.powernode.mall.dto.ShopInfo;
import com.powernode.mall.po.TShop;
import com.powernode.mall.service.IShopService;
import com.powernode.mall.util.JsonResult;
import com.powernode.mall.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("shop")
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
    public JsonResult<ShopInfo> getShopInfo(Integer sid) {
        ShopInfo shopInfo = shopService.getShopInfoBySid(sid);
        return new JsonResult<>(OK, shopInfo);
    }

    @RequestMapping("insert_shop")
    public JsonResult<?> insertShop(@RequestBody TShop shop) {
        shopService.insertShop(shop);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_shop_info_by_sid")
    public JsonResult<ShopInfo> getShopInfoBySid(@RequestParam("sid") Integer sid) {
        ShopInfo shopinfo = shopService.getShopInfoBySid(sid);
        return new JsonResult<>(OK, shopinfo);
    }

    @RequestMapping("get_shop_by_sid")
    public JsonResult<TShop> getShopBySid(@RequestParam("sid") Integer sid) {
        TShop shop = shopService.getShopBySid(sid);
        return new JsonResult<>(OK, shop);
    }

}
