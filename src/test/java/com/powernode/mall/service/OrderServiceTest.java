package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.VersionNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class OrderServiceTest {

    @Autowired
    IOrderService orderService;

    @Test
    public void submitOrderServiceTest1() {
        Integer ret = orderService.submitOrder("user2",11,"version_41", 3, 4);
        Assertions.assertNotNull(ret);
    }

    @Test
    public void getProductDetailServiceTest0() {
        boolean thrown=false;
        try {
            Integer ret = orderService.submitOrder("user2",10,"version_1uytfcvbyg", 3, 4);
        }catch (VersionNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }
}
