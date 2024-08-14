package com.powernode.mall.service.impl;

import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.mapper.TImageMapper;
import com.powernode.mall.mapper.TProductMapper;
import com.powernode.mall.mapper.TShopMapper;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShopServiceImpl implements IShopService {

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private TShopMapper shopMapper;

    @Autowired
    private TImageMapper imageMapper;

    @Override
    public ArrayList<ShopItem> getAllProducts(Integer sid) {
        ArrayList<ShopItem> shopItems = new ArrayList<>();
        ArrayList<TProduct> products = productMapper.selectBySid(sid);

        for(TProduct product : products){
            ShopItem shopItem = new ShopItem();
            shopItem.setPid(product.getPid());
            shopItem.setPrice(product.getPrice());
            shopItem.setName(product.getProductName());
            shopItem.setImageSrc(
                    imageMapper.selectByPid(product.getPid()).get(0).getImageSrc()
            );

            shopItems.add(shopItem);
        }

        return shopItems;
    }
}
