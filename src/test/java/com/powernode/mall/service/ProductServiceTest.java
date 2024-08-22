package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.service.ex.ProductNotFoundException;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

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
}
