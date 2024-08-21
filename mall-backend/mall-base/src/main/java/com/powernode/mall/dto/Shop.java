package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private Integer sid;
    private String shopName;
    private ArrayList<String> shopGoodsImage;
    private Integer shopSubscriberCount;
    private Integer shopSaleCount;
}
