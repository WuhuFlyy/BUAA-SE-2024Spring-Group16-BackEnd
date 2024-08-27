package com.powernode.mall.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.powernode.mall.client.ProductClient;
import com.powernode.mall.controller.BaseController;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements IProductService {
    @Autowired
    private ProductClient productClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public ProductDetails get(int id) {
        return productClient.getProductById(id).getData();
    }

    public ProductDetails fallbackMethod() {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("等待");
        return productDetails;
    }
}
