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
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Test
    public void submitTest1() {
        JsonResult<Integer> result = orderController.submit("user0", 1,"version_72", 1, 9);
        Assertions.assertEquals(result.getStateCode(), 200);
    }

    @Test
    public void submitTest0() {
        boolean thrown=false;
        try {
            JsonResult<Integer> result = orderController.submit("user0", 1,"version_72", 1, -100);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }
}
