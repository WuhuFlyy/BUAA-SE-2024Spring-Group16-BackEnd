package com.powernode.mall.service;

public interface IFavoriteProductService {
    void addFavoriteProduct(String username, Integer pid);
    void removeFavoriteProduct(String username, Integer pid);
    boolean isFavoriteProduct(String username, Integer pid);
}