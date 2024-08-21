package com.powernode.mall.service;

public interface IFavoriteShopService {

    void addFavoriteShop(String username, Integer shopId);

    void removeFavoriteShop(String username, Integer shopId);

    boolean isFavoriteShop(String username, Integer sid);
}