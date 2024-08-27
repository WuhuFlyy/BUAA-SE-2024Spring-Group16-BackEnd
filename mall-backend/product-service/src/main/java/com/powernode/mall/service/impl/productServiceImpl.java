package com.powernode.mall.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
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
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
        @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"),// 是否开启熔断器
        @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "20"),      // 统计时间窗内请求次数
        @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "15"),// 在统计时间窗内，失败率达到50%进入熔断状态
        @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000"), // 休眠时间窗口
        @HystrixProperty(name = HystrixPropertiesManager.METRICS_ROLLING_STATS_TIME_IN_MILLISECONDS, value = "10000") // 统计时间窗

    })
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
