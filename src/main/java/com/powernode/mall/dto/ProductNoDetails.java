package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductNoDetails {
    private Integer productID;
    private String productName;
    private String productImageBig;
    private Double salePrice;
}
