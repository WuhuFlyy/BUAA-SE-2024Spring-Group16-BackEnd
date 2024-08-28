package com.powernode.mall.client;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shop-service", url = "http://base-service:80", fallback = ProductClientFallback.class)
public interface ProductClient {
    @RequestMapping("products/details")
    public JsonResult<ProductDetails> getProductById(@RequestParam("id") int id);
}
