package com.powernode.mall.service;

public interface ICartService {

    /**
     * 新增购物车项
     * @param username 用户名
     * @param pid 商品id
     * @param quantity 数量
     */
    Void addToCart(String username, Integer pid, String version, Integer quantity);
}
