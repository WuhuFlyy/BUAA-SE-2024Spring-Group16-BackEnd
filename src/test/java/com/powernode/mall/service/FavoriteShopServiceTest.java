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
public class FavoriteShopServiceTest {

    @Autowired
    IFavoriteShopService favoriteShopService;

    @Test
    public void addFavoriteShopServiceTest1() {
        boolean thrown = false;
        try{
            favoriteShopService.addFavoriteShop("user0",3);
        }catch (Exception e){
            thrown = true;
        }
        Assertions.assertFalse(thrown);
        favoriteShopService.removeFavoriteShop("user0",3);
    }

    @Test
    public void addFavoriteShopServiceTest0() {
        boolean thrown = false;
        try{
            favoriteShopService.addFavoriteShop("user0",30000);
        }catch (ShopNotFoundException e){
            thrown = true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void removeFavoriteShopServiceTest1() {
        boolean thrown = false;
        favoriteShopService.addFavoriteShop("user0",3);
        try{
            favoriteShopService.removeFavoriteShop("user0",3);
        }catch (Exception e){
            thrown = true;
        }
        Assertions.assertFalse(thrown);
    }

    @Test
    public void removeFavoriteShopServiceTest0() {
        boolean thrown = false;
        try{
            favoriteShopService.removeFavoriteShop("user0",30000);
        }catch (ShopNotFoundException e){
            thrown = true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void isFavoriteShopServiceTest1() {
        boolean thrown = false;
        favoriteShopService.addFavoriteShop("user0",3);
        Assertions.assertTrue(favoriteShopService.isFavoriteShop("user0",3));
        favoriteShopService.removeFavoriteShop("user0",3);
    }

    @Test
    public void isFavoriteShopServiceTest0() {
        Assertions.assertFalse(favoriteShopService.isFavoriteShop("user0",31283));
    }
}
