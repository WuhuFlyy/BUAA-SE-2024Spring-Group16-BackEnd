package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopItem {
    private Integer pid;
    private String name;
    private Double price;
    private String imageSrc;
}
