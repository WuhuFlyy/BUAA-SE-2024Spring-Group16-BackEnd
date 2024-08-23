package com.powernode.mall.po;

import lombok.Data;

import java.util.Date;

@Data
public class TCart {
    private Integer cid;

    private Integer uid;

    private Integer pid;

    private Integer quantity;

    private String version;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;


}