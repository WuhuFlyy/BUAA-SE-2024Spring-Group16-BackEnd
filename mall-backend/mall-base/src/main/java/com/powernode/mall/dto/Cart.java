package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer cid;
    private Integer productId;
    private String productName;
    private Double salePrice;
    private String selectedVersion;
    private Integer quantity;
    private Double total;
}
