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
}
