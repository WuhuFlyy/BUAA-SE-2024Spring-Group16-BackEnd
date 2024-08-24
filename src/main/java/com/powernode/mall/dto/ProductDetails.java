package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    private Integer productId;
    private String name;
    private Integer storage;
    private ArrayList<String> version;
    private Double price;
    private ArrayList<String> imageSrc;
    private String details;
    private String shopName;
    private Integer shopId;
    private ArrayList<Comment> comments;

    public ProductDetails(String name, Integer storage, ArrayList<String> version, Double price, ArrayList<String> imageSrc, String details, String shopName, Integer shopId) {
        this.name = name;
        this.storage = storage;
        this.version = version;
        this.price = price;
        this.imageSrc = imageSrc;
        this.details = details;
        this.shopName = shopName;
        this.shopId = shopId;
    }

    public ProductDetails(Integer productId, String name, Integer storage, ArrayList<String> version, Double price, ArrayList<String> imageSrc, String details, String shopName, Integer shopId) {
        this.productId = productId;
        this.name = name;
        this.storage = storage;
        this.version = version;
        this.price = price;
        this.imageSrc = imageSrc;
        this.details = details;
        this.shopName = shopName;
        this.shopId = shopId;
    }
}
