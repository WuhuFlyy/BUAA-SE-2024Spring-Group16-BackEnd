package com.powernode.mall.service;

import com.powernode.mall.dto.Cart;

import java.util.ArrayList;

public interface ICartService {

    /**
     * 新增购物车项
     * @param username 用户名
     * @param pid 商品id
     * @param quantity 数量
     */
    void addToCart(String username, Integer pid, String version, Integer quantity);

    void addNum(int cid);

    void reduceNum(int cid);

    void deleteCart(int cid);

    ArrayList<Cart> getCartByUsername(String username);
}
