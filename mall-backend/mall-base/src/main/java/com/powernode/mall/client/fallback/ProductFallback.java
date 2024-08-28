package com.powernode.mall.client.fallback;

import com.powernode.mall.client.ProductClient;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductFallback implements ProductClient {
    @Override
    public JsonResult<TProduct> getByPid(Integer pid) {
        return new JsonResult<>(200, new TProduct());
    }

    @Override
    public JsonResult<TProduct> getDetailsByPid(Integer pid) {
        return new JsonResult<>(200, new TProduct());
    }

    @Override
    public JsonResult<TProduct> getAllProducts() {
        return new JsonResult<>(200, new TProduct());
    }

    @Override
    public JsonResult<TProduct> getProductByKeywords(String keywords) {
        return new JsonResult<>(200, new TProduct());
    }

    @Override
    public JsonResult<Void> insertProduct(TProduct product) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<Void> updateProduct(TProduct product) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<ArrayList<TProduct>> getByShopId(Integer sid) {
        return new JsonResult<>(200, new ArrayList<TProduct>());
    }
}
