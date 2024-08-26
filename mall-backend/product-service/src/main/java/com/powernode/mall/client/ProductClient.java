package com.powernode.mall.client;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shop-service", url = "http://10.110.248.238:80")
public interface ProductClient {
    @RequestMapping("products/details")
    public JsonResult<ProductDetails> getProductById(@RequestParam("id") int id);
}
