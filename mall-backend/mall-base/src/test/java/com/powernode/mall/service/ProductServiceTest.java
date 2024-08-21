package com.powernode.mall.service;

import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    IProductService productService;

    @Test
    public void getProductDetailTest() {
        System.out.println(JSONValue.toJSONString(productService.getProductDetailByProductId(2)));
    }
}
