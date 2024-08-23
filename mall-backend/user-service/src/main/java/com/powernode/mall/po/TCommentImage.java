package com.powernode.mall.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCommentImage {
    private Integer ciid;

    private Integer uid;

    private Integer cid;

    private String imageSrc;
}