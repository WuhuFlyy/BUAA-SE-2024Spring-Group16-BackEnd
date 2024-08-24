package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.ShopNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class FavoriteProductServiceTest {

    @Autowired
    IFavoriteProductService favoriteProductService;

    @Test
    public void addFavoriteProductServiceTest1() {
        boolean thrown = false;
        try{
            favoriteProductService.addFavoriteProduct("user0",3);
        }catch (Exception e){
            thrown = true;
        }
        Assertions.assertFalse(thrown);
        favoriteProductService.removeFavoriteProduct("user0",3);
    }

    @Test
    public void addFavoriteProductServiceTest0() {
        boolean thrown = false;
        try{
            favoriteProductService.addFavoriteProduct("user0",30000);
        }catch (ShopNotFoundException e){
            thrown = true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void removeFavoriteProductServiceTest1() {
        boolean thrown = false;
        favoriteProductService.addFavoriteProduct("user0",3);
        try{
            favoriteProductService.removeFavoriteProduct("user0",3);
        }catch (Exception e){
            thrown = true;
        }
        Assertions.assertFalse(thrown);
    }

    @Test
    public void removeFavoriteProductServiceTest0() {
        boolean thrown = false;
        try{
            favoriteProductService.removeFavoriteProduct("user0",30000);
        }catch (ShopNotFoundException e){
            thrown = true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void isFavoriteProductServiceTest1() {
        boolean thrown = false;
        favoriteProductService.addFavoriteProduct("user0",3);
        Assertions.assertTrue(favoriteProductService.isFavoriteProduct("user0",3));
        favoriteProductService.removeFavoriteProduct("user0",3);
    }

    @Test
    public void isFavoriteProductServiceTest0() {
        Assertions.assertFalse(favoriteProductService.isFavoriteProduct("user0",31283));
    }
}
