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
public class FavoriteProductControllerTest {

    @Autowired
    private FavoriteProductController favoriteProductController;

    @Test
    public void addFavoriteProductTest1() {
        JsonResult<Void> result = favoriteProductController.addFavoriteProduct("user0", 2);
        Assertions.assertEquals(result.getStateCode(),200);
    }

    @Test
    public void addFavoriteProductTest0() {
        boolean thrown=false;
        try {
            JsonResult<Void> result = favoriteProductController.addFavoriteProduct("user0", -100);
        }catch (Exception e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void removeFavoriteProductTest1() {
        JsonResult<Void> result = favoriteProductController.removeFavoriteProduct("user0", 1);
        Assertions.assertEquals(result.getStateCode(),200);
    }

//    @Test
//    public void removeFavoriteProductTest0() {
//        boolean thrown=false;
//        try {
//            JsonResult<Void> result = favoriteProductController.removeFavoriteProduct("user0", -100);
//        } catch (Exception e) {
//            thrown=true;
//        }
//        Assertions.assertTrue(thrown);
//    }

    @Test
    public void isFavoriteProductTest1() {
        JsonResult<Boolean> result = favoriteProductController.isFavoriteProduct("user0", 10);
        Assertions.assertEquals(result.getData(),true);
    }

    @Test
    public void isFavoriteProductTest0() {
        boolean thrown=false;
        try {
            JsonResult<Boolean> result = favoriteProductController.isFavoriteProduct("userUnknown", 10);
        } catch(Exception e) {
            thrown=true;
        }
        Assertions.assertTrue(thrown);

    }
}
