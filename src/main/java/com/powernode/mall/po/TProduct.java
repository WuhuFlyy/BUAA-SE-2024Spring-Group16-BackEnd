package com.powernode.mall.po;

import lombok.Data;

import java.util.Date;

@Data
public class TProduct {
    private Integer pid;

    private Integer sid;

    private String productName;

    private Double price;

    private String details;

    private Integer isHot;

    private Integer storage;

    private String image;

    private Integer status;

    private Integer priority;

    private Date createdTime;

    private Date modifiedTime;

    private String createdUser;

    private String modifiedUser;

}