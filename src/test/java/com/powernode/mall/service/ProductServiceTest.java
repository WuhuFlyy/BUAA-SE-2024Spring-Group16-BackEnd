package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    IProductService productService;

    @Test
    public void getProductDetailServiceTest() {
        System.out.println(productService.getProductDetailByProductId(2));
//        ProductDetails productDetails = new ProductDetails();
//        productDetails.setProductId(1);
//        productDetails.setDetails("This is its details");
//        productDetails.setName("product1");
//        productDetails.setPrice(100.11);
//        productDetails.setStorage(10);
//        when(productService.getProductDetailByProductId(1)).thenReturn(productDetails);
//
//        ProductDetails productDetails1 = productService.getProductDetailByProductId(1);
//        assert(productDetails1.equals(productDetails));
    }
}
