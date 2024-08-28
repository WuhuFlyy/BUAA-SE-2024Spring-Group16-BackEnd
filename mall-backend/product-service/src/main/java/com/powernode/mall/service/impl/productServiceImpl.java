package com.powernode.mall.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
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
    public ProductDetails get(int id) {
        throw new RuntimeException("Aaaaaaaaaaa");
    }

    public ProductDetails fallbackMethod(int id) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(id);
        productDetails.setName("等待");
        return productDetails;
    }
}
