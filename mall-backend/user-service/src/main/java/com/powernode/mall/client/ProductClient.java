package com.powernode.mall.client;


import com.powernode.mall.client.fallback.ProductFallback;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.po.TShop;
import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import jakarta.security.auth.message.MessagePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8889", fallback = ProductFallback.class)
public interface ProductClient {

    @RequestMapping("/products/get_by_pid")
    public JsonResult<TProduct> getByPid(@RequestParam("pid") Integer pid);
}
