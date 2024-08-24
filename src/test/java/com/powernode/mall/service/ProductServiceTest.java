package com.powernode.mall.service;

import com.powernode.mall.dto.Comment;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.service.ex.ProductDataIllegalException;
import com.powernode.mall.service.ex.ProductNotFoundException;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class ProductServiceTest {

    @Autowired
    IProductService productService;

    @Test
    public void getProductDetailServiceTest1() {
        ProductDetails productDetails = productService.getProductDetailByProductId(2);
        Assertions.assertEquals(productDetails.getName(),"product_12");
    }

    @Test
    public void getProductDetailServiceTest0() {
        boolean thrown=false;
        try {
            ProductDetails productDetails = productService.getProductDetailByProductId(200);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void selectByPrimaryKeyTest1() {
        TProduct tProduct = productService.selectByPrimaryKey(10);
        Assertions.assertEquals(tProduct.getPid(), 10);
    }

    @Test
    public void selectByPrimaryKeyTest0() {
        boolean thrown=false;
        try {
            TProduct tProduct = productService.selectByPrimaryKey(100);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void getAllProductsTest1() {
        List<ProductNoDetails> tProducts = productService.getAllProducts();
        Assertions.assertTrue(tProducts.size()<100);
    }

    @Test
    public void getAllProductsTest0() {
        List<ProductNoDetails> tProducts = productService.getAllProducts();
        Assertions.assertFalse(tProducts.size()>100);
    }

    @Test
    public void getProductByKeywordsTest1() {
        ArrayList<ShopItem> Products = productService.getProductByKeywords("12");
        Assertions.assertNotNull(Products);
    }

    @Test
    public void getProductByKeywordsTest0() {
        ArrayList<ShopItem> Products = productService.getProductByKeywords("sahjdkopia9s89ufy7guhsbkjaiu9u8dfyuigh");
        Assertions.assertNull(Products);
    }

    @Test
    public void insertProductTest1() {
        boolean thrown=false;
        Date date = new Date();
        ArrayList<String> v = new ArrayList<String>();
        v.add("version1");
        ArrayList<String> i = new ArrayList<String>();
        i.add("image1");
        try {
            ProductDetails product = new ProductDetails(
                    "newProduct", 12, v, 99.99, i, "details",
                    "shop1", 2
            );
            productService.insertProduct(product);
        }catch (ProductDataIllegalException e){
            thrown=true;
        }
        Assertions.assertFalse(thrown);
    }

    @Test
    public void insertProductTest0() {
        boolean thrown=false;
        Date date = new Date();
        ArrayList<String> v = new ArrayList<String>();
        v.add("version1");
        ArrayList<String> i = new ArrayList<String>();
        i.add("image1");
        try {
            ProductDetails product = new ProductDetails(
                    "newProduct", -12, v, 99.99, i, "details",
                    "shop1", 2
            );
            productService.insertProduct(product);
        }catch (ProductDataIllegalException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void updateProductTest1() {
        boolean thrown=false;
        Date date = new Date();
        ArrayList<String> v = new ArrayList<String>();
        v.add("version1");
        ArrayList<String> i = new ArrayList<String>();
        i.add("image1");
        try {
            ProductDetails product = new ProductDetails(
                    1,"newProduct", 12, v, 99.99, i, "details",
                    "shop1", 2
            );
            productService.updateProduct(product);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertFalse(thrown);
    }

    @Test
    public void updateProductTest0() {
        boolean thrown=false;
        Date date = new Date();
        ArrayList<String> v = new ArrayList<String>();
        v.add("version1");
        ArrayList<String> i = new ArrayList<String>();
        i.add("image1");
        try {
            ProductDetails product = new ProductDetails(
                    100,"newProduct", 12, v, 99.99, i, "details",
                    "shop1", 2
            );
            productService.updateProduct(product);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

}
