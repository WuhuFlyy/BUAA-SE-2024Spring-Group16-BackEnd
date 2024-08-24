package com.powernode.mall.service;

import com.powernode.mall.dto.Product;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.Shop;
import com.powernode.mall.dto.ShopInfo;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.ShopNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class ShopServiceTest {

    @Autowired
    private IShopService shopService;

    @Test
    public void getAllProductsServiceTest1() {
        ArrayList<Product> productDetailsList = shopService.getAllProducts(2);
        Assertions.assertNotNull(productDetailsList);
    }

    @Test
    public void getProductDetailServiceTest0() {
        boolean thrown=false;
        try {
            ArrayList<Product> productDetailsList = shopService.getAllProducts(2000);
        }catch (ShopNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void getShopByKeywordsServiceTest1() {
        ArrayList<Shop> shops = shopService.getShopByKeywords("shop");
        Assertions.assertNotNull(shops);
    }

    @Test
    public void getShopByKeywordsServiceTest0() {
        ArrayList<Shop> shops = shopService.getShopByKeywords("shopsdbnasklfgdvsjhbklfdhgjk");
        Assertions.assertEquals(shops.size(), 0);
    }

    @Test
    public void getShopInfoBySidServiceTest1() {
        ShopInfo shopInfo = shopService.getShopInfoBySid(3);
        Assertions.assertNotNull(shopInfo);
    }

    @Test
    public void getShopInfoBySidServiceTest0() {
        boolean thrown=false;
        try {
            ShopInfo shopInfo = shopService.getShopInfoBySid(3000);
        }catch (ShopNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }


}
