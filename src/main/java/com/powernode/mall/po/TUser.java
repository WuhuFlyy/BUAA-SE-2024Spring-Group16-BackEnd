package com.powernode.mall.po;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {
    private Integer uid;

    private String username;

    private String type;

    private String password;

    private String salt;

    private String phone;

    private String email;

    private String gender;

    private String avatar;

    private Integer isDelete;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;

}