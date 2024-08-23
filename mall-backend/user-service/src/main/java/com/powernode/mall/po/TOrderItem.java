package com.powernode.mall.po;

import lombok.Data;

import java.util.Date;

@Data
public class TOrderItem {
    private Integer oiid;

    private Integer oid;

    private Integer pid;

    private String version;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;

}