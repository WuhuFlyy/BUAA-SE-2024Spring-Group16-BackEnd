package com.powernode.mall.controller;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.util.JsonResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Test
    public void getProductDetailServiceTest1() {
        JsonResult<ProductDetails> productDetails = productController.getById(2);
        Assertions.assertEquals(productDetails.getData().getName(),"product_12");
    }

    @Test
    public void getProductDetailServiceTest0() {
        boolean thrown=false;
        try {
            JsonResult<ProductDetails> productDetails = productController.getById(200);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void getAllProductTest1() {
        JsonResult<List<ProductNoDetails>> products = productController.getAllProducts();
        Assertions.assertEquals(products.getStateCode(), 200);
    }

    @Test
    public void searchProductByKeywordsTest1() {
        JsonResult<?> shopItems = productController.search("2");
        Assertions.assertNotEquals(shopItems.getData(),null);
    }

    @Test
    public void searchProductByKeywordsTest0() {
        boolean thrown = false;
        try {
            JsonResult<?> shopItems = productController.search("asadssada");
        } catch (Exception e) {
            thrown = true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void uploadProductTest1() {
        boolean thrown = false;
        ArrayList<String> version =  new ArrayList<String>();
        ArrayList<String> imageSrc =  new ArrayList<String>();
        version.add("a");
        imageSrc.add("../s.png");
        try {
            ProductDetails productDetails = new ProductDetails("thisIsAProduct", 10, version, 10.12, imageSrc, "666", "shop2", 3);
            Assertions.assertEquals(productController.upload(productDetails).getStateCode(), 200);
        } catch (Exception e) {
            thrown = true;
        }
    }

    @Test
    public void uploadProductTest0() {
        boolean thrown = false;
        ArrayList<String> version =  new ArrayList<String>();
        ArrayList<String> imageSrc =  new ArrayList<String>();
        version.add("a");
        imageSrc.add("../s.png");
        try {
            ProductDetails productDetails = new ProductDetails("thisIsAProduct", 10, version, 10.12, imageSrc, "666", "shop2", -100);
            Assertions.assertNotEquals(productController.upload(productDetails).getStateCode(), 200);
        } catch (Exception e) {
            thrown = true;
        }
    }

    @Test
    public void updateProductTest1() {
        boolean thrown = false;
        ArrayList<String> version =  new ArrayList<String>();
        ArrayList<String> imageSrc =  new ArrayList<String>();
        version.add("a");
        imageSrc.add("../s.png");
        try {
            ProductDetails productDetails = new ProductDetails(1,"product_14", 120, version, 10.12, imageSrc, "666", "shop1", 2);
            Assertions.assertEquals(productController.upload(productDetails).getStateCode(), 200);
        } catch (Exception e) {
            thrown = true;
        }
    }

    @Test
    public void updateProductTest0() {
        boolean thrown = false;
        ArrayList<String> version =  new ArrayList<String>();
        ArrayList<String> imageSrc =  new ArrayList<String>();
        version.add("a");
        imageSrc.add("../s.png");
        try {
            ProductDetails productDetails = new ProductDetails(-100,"product_14", 120, version, 10.12, imageSrc, "666", "shop1", 2);
            Assertions.assertNotEquals(productController.upload(productDetails).getStateCode(), 200);
        } catch (Exception e) {
            thrown = true;
        }
    }
}
