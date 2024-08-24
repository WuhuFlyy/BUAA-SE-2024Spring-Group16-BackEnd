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
public class FavoriteShopControllerTest {

    @Autowired
    private FavoriteShopController favoriteShopController;

    @Test
    public void addFavoriteShopTest1() {
        JsonResult<Void> result = favoriteShopController.addFavoriteShop("user1", 2);
        Assertions.assertEquals(result.getStateCode(),200);
    }

    @Test
    public void addFavoriteShopTest0() {
        boolean thrown=false;
        try {
            JsonResult<Void> result = favoriteShopController.addFavoriteShop("user1", -100);
        }catch (Exception e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void removeFavoriteShopTest1() {
        JsonResult<Void> result = favoriteShopController.removeFavoriteShop("user1", 7);
        Assertions.assertEquals(result.getStateCode(),200);
    }

    @Test
    public void removeFavoriteShopTest0() {
        boolean thrown=false;
        try {
            JsonResult<Void> result = favoriteShopController.removeFavoriteShop("user1", -100);
        } catch (Exception e) {
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void isFavoriteShopTest1() {
        JsonResult<Boolean> result = favoriteShopController.isFavoriteShop("user1", 10);
        Assertions.assertEquals(result.getData(),true);
    }

    @Test
    public void isFavoriteShopTest0() {
        boolean thrown=false;
        try {
            JsonResult<Boolean> result = favoriteShopController.isFavoriteShop("userUnknown", 10);
        } catch(Exception e) {
            thrown=true;
        }
        Assertions.assertTrue(thrown);

    }
}
