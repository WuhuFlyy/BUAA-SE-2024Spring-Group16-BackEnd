package com.powernode.mall.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TProduct {
    private Integer pid;

    private Integer sid;

    private String productName;

    private Double price;

    private String details;

    private Integer isHot;

    private Integer storage;

    private Integer saleVolume;

    private String image;

    private Integer status;

    private Integer priority;

    private Date createdTime;

    private Date modifiedTime;

    private String createdUser;

    private String modifiedUser;

    public TProduct(Integer sid, String productName, Double price, String details, Integer isHot, Integer storage, Integer saleVolume, String image, Integer status, Integer priority, Date createdTime, Date modifiedTime, String createdUser, String modifiedUser) {
        this.sid = sid;
        this.productName = productName;
        this.price = price;
        this.details = details;
        this.isHot = isHot;
        this.storage = storage;
        this.saleVolume = saleVolume;
        this.image = image;
        this.status = status;
        this.priority = priority;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.createdUser = createdUser;
        this.modifiedUser = modifiedUser;
    }
}