package com.powernode.mall.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pid;
    private String name;
    private Double price;
    private String imageSrc;
    private Boolean isHot;
}
