package com.powernode.mall.controller;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

    @Autowired
    IProductService productService;

    @RequestMapping("get_by_pid")
    public JsonResult<TProduct> getByPid(@RequestParam("pid") Integer pid){
        TProduct tProduct = productService.selectByPrimaryKey(pid);
        return new JsonResult<>(OK, tProduct);
    }

    @RequestMapping("details")
    public JsonResult<ProductDetails> getDetailsByPid(@RequestParam("pid") Integer pid){
        ProductDetails productDetails = productService.getProductDetailByProductId(pid);
        return new JsonResult<>(OK, productDetails);
    }

    @RequestMapping("all")
    public JsonResult<List<ProductNoDetails>> getAllProducts() {
        List<ProductNoDetails> products = productService.getAllProducts();
        return new JsonResult<>(OK, products);
    }

    @RequestMapping("search")
    public JsonResult<ArrayList<ShopItem>> getProductByKeywords(@RequestParam("keywords") String keywords) {
        ArrayList<ShopItem> products = productService.getProductByKeywords(keywords);
        return new JsonResult<>(OK, products);
    }

    @PostMapping("upload")
    public JsonResult<Void> insertProduct(@RequestBody ProductDetails product) {
        productService.insertProduct(product);
        return new JsonResult<>(OK);
    }

    @PostMapping("update")
    public JsonResult<Void> updateProduct(@RequestBody ProductDetails product) {
        productService.updateProduct(product);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_shop_id")
    public JsonResult<ArrayList<TProduct>> getByShopId(@RequestParam("sid") Integer sid) {
        ArrayList<TProduct> products = productService.getByShopId(sid);
        return new JsonResult<>(OK, products);
    }
}
