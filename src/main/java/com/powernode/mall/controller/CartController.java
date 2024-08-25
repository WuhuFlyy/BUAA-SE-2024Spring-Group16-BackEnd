package com.powernode.mall.controller;

import com.powernode.mall.dto.Cart;
import com.powernode.mall.service.ICartService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins="*")
public class CartController extends BaseController {

    @Autowired
    ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> add_to_cart(String username, Integer pid, String version, Integer quantity) {
        cartService.addToCart(username, pid, version, quantity);
        return new JsonResult<>(OK);
    }

    @RequestMapping("add_num")
    public JsonResult<Void> addNum(int cid) {
        cartService.addNum(cid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("reduce_num")
    public JsonResult<Void> reduceNum(int cid) {
        cartService.reduceNum(cid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("list")
    public JsonResult<ArrayList<Cart>> list(String username) {
        ArrayList<Cart> carts = cartService.getCartByUsername(username);
        return new JsonResult<>(OK, carts);
    }
}
