package com.powernode.mall.po;

import lombok.Data;

import java.util.Date;

@Data
public class TOrder {
    private Integer oid;

    private Integer uid;

    private Integer aid;

    private Double totalPrice;

    private Integer status;

    private Date orderTime;

    private Date payTime;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;

    private String version;

    private Integer quantity;

}