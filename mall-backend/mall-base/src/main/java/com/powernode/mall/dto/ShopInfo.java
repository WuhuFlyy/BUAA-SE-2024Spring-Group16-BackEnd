package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopInfo {
    private String shopName;
    private Integer shopSubscriberCount;
    private Integer shopSaleCount;
}
