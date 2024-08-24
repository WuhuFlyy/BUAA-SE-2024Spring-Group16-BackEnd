package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.service.ex.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class CartServiceTest {

    @Autowired
    ICartService cartService;

    @Test
    public void addToCartDetailServiceTest1() {
        boolean thrown = false;
        try{
            cartService.addToCart("user0",13,"version_7",20);
        }catch (Exception e){
            thrown = true;
        }

        Assertions.assertFalse(thrown);
    }

    @Test
    public void addToCartDetailServiceTest0() {
        boolean thrown = false;
        try{
            cartService.addToCart("user0",1312,"version_7",20);
        }catch (ProductNotFoundException e){
            thrown = true;
        }

        Assertions.assertFalse(thrown);
    }
}
