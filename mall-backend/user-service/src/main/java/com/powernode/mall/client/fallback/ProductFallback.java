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
}
