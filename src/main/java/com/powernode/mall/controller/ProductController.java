package com.powernode.mall.controller;

import com.powernode.mall.entity.Product;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product product = productService.getProductDetailByProductId(id);
        return new JsonResult<Product>(OK, product);
    }
}
