package com.powernode.mall.service;


import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.Product;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.po.TProduct;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

import java.util.ArrayList;

public interface IProductService {
   ProductDetails get(int id) throws Exception;
}
