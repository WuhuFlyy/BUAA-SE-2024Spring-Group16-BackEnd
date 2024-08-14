package com.powernode.mall.service;

import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.dto.Product;

import java.util.ArrayList;

public interface IShopService {
    /**
     * 根据商店id获取所有商品
     * @param sid 商店id
     * @return 所有商品条目
     */
    ArrayList<Product> getAllProducts(Integer sid);
}
