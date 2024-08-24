package com.powernode.mall.controller;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.util.JsonResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class CartControllerTest {

    @Autowired
    private CartController cartController;

    @Test
    public void addToCartTest1() {
        JsonResult<Void> result = cartController.add_to_cart("user0", 1,"version_72", 1);
        Assertions.assertEquals(result.getStateCode(), 200);
    }

    @Test
    public void addToCartTest0() {
        boolean thrown = false;
        try {
            JsonResult<Void> result = cartController.add_to_cart("user0", -100,"version_72", 1);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }
}
