package com.powernode.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    private Integer id;
    private String userName;
    private Double rate;
    private String content;
    private ArrayList<String> images;
    private Integer productId;
}
