package com.powernode.mall.controller;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.Shop;
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
public class ShopControllerTest {

    @Autowired
    private ShopController shopController;

    @Test
    public void getProductsTest1() {
        JsonResult<?> result = shopController.getProducts(2);
        Assertions.assertNotNull(result.getData());
    }

    @Test
    public void getProductsTest0() {
        boolean thrown=false;
        try {
            JsonResult<?> result = shopController.getProducts(-100);
        }catch (Exception e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void searchShopByKeywordsTest1() {
        JsonResult<?> shopItems = shopController.search("2");
        Assertions.assertNotNull(shopItems.getData());
    }

    @Test
    public void getShopInfoTest1() {
        JsonResult<?> result = shopController.getShopInfo(2);
        Assertions.assertNotNull(result.getData());
    }

    @Test
    public void getShopInfoTest0() {
        boolean thrown=false;
        try {
            JsonResult<?> result = shopController.getShopInfo(-100);
        }catch (Exception e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }
}
