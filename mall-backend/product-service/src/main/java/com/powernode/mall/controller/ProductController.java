package com.powernode.mall.controller;

import com.powernode.mall.po.TProduct;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

    @Autowired
    IProductService productService;

    @RequestMapping("get_by_pid")
    public JsonResult<?> getByPid(@RequestParam("pid") Integer pid){
        TProduct tProduct = productService.selectByPrimaryKey(pid);
        return new JsonResult<>(OK, tProduct);
    }
}
