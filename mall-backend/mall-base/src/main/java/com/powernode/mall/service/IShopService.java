package com.powernode.mall.service;

import com.powernode.mall.dto.Shop;
import com.powernode.mall.dto.ShopInfo;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.dto.Product;
import com.powernode.mall.po.TShop;

import java.util.ArrayList;

public interface IShopService {
    /**
     * 根据商店id获取所有商品
     * @param sid 商店id
     * @return 所有商品条目
     */
    ArrayList<Product> getAllProducts(Integer sid);

    /**
     * 根据关键词搜素商店
     * @param keywords 关键词
     * @return 所有含关键词的商店
     */
    ArrayList<Shop> getShopByKeywords(String keywords);

    /**
     * 根据商店id获取商店信息
     * @param sid 商店id
     * @return 商店信息
     */
    ShopInfo getShopInfoBySid(Integer sid);

    /**
     * 插入新商店
     * @param shop 商店信息
     */
    void insertShop(TShop shop);
}
