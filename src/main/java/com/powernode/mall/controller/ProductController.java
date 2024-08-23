package com.powernode.mall.controller;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("products")
@CrossOrigin(origins="*")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("details")
    public JsonResult<ProductDetails> getById(Integer id){
        ProductDetails productDetails = productService.getProductDetailByProductId(id);
        return new JsonResult<ProductDetails>(OK, productDetails);
    }

    @RequestMapping("all")
    public JsonResult<List<ProductNoDetails>> getAllProducts() {
        List<ProductNoDetails> products = productService.getAllProducts();
        return new JsonResult<>(OK, products);
    }


    @RequestMapping("search")
    public JsonResult<?> search(String keywords){
        ArrayList<ShopItem> shopItems = productService.getProductByKeywords(keywords);
        return new JsonResult<>(OK, shopItems);
    }

    @RequestMapping("upload")
    public JsonResult<Void> upload(@RequestBody ProductDetails productDetails){
        productService.insertProduct(productDetails);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<Void> update(@RequestBody ProductDetails productDetails){
        productService.updateProduct(productDetails);
        return new JsonResult<>(OK);
    }
}
