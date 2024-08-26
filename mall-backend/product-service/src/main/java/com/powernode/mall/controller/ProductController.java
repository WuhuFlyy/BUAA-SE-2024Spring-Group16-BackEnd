package com.powernode.mall.controller;

import com.powernode.mall.client.ProductClient;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.mapper.TProductMapper;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.ArrayList;

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
