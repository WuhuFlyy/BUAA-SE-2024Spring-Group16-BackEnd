package com.powernode.mall.controller;

import com.powernode.mall.service.ICartService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController extends BaseController {

    @Autowired
    ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> add_to_cart(String username, Integer pid, String version, Integer quantity) {
        cartService.addToCart(username, pid, version, quantity);
        return new JsonResult<>(OK);
    }
}
