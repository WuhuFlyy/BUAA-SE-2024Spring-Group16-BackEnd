package com.powernode.mall.client;


import com.powernode.mall.po.TProduct;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "http://localhost:8889")
public interface ProductClient {

    @RequestMapping("/products/get_by_pid")
    public JsonResult<TProduct> getByPid(@RequestParam("pid") Integer pid);
}
