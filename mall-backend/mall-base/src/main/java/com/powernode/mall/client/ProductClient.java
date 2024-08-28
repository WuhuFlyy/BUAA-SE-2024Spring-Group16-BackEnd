package com.powernode.mall.client;


import com.powernode.mall.client.fallback.ProductFallback;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient(name = "product-service", url = "http://product-service:80", fallback = ProductFallback.class)
public interface ProductClient {

    @RequestMapping("/products/get_by_pid")
    public JsonResult<TProduct> getByPid(@RequestParam("pid") Integer pid);

    @RequestMapping("/products/get_details_by_pid")
    public JsonResult<TProduct> getDetailsByPid(@RequestParam("pid") Integer pid);

    @RequestMapping("/products/get_all_products")
    public JsonResult<TProduct> getAllProducts();

    @RequestMapping("/products/get_product_by_keywords")
    public JsonResult<TProduct> getProductByKeywords(@RequestParam("keywords") String keywords);

    @RequestMapping("/products/insert_product")
    public JsonResult<Void> insertProduct(@RequestParam("product") TProduct product);

    @RequestMapping("/products/update_product")
    public JsonResult<Void> updateProduct(@RequestParam("product") TProduct product);

    @RequestMapping("/products/get_by_shop_id")
    public JsonResult<ArrayList<TProduct>> getByShopId(@RequestParam("sid") Integer sid);
}
