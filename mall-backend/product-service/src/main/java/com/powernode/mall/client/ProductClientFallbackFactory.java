package com.powernode.mall.client;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import static com.powernode.mall.controller.BaseController.OK;

@Slf4j
@Component
public class ProductClientFallbackFactory implements FallbackFactory<ProductClient> {
    public ProductClientFallbackFactory() {
        System.out.println("ProductClientFallback已加载");
    }

    @Override
    public ProductClient create(Throwable cause) {
        return new ProductClient() {
            @Override
            public JsonResult<ProductDetails> getProductById(int id) {
                System.out.println("降级方法");
                ProductDetails productDetails = new ProductDetails();
                productDetails.setProductId(id);
                productDetails.setName("等待");
                return new JsonResult<>(OK,  productDetails);
            }
        };
    }
}
