package com.powernode.mall.po;

import lombok.Data;

@Data
public class TComment {
    private Integer cid;

    private Integer uid;

    private Integer pid;

    private Double rate;

    private String content;

}