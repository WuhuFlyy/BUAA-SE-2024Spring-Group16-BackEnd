package com.powernode.mall.service.impl;

import com.powernode.mall.client.ProductClient;
import com.powernode.mall.client.UserClient;
import com.powernode.mall.dto.Shop;
import com.powernode.mall.dto.ShopInfo;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.dto.Product;
import com.powernode.mall.mapper.TImageMapper;
import com.powernode.mall.mapper.TProductMapper;
import com.powernode.mall.mapper.TShopMapper;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.po.TShop;
import com.powernode.mall.service.IShopService;
import com.powernode.mall.service.ex.ShopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShopServiceImpl implements IShopService {

//    @Autowired
//    private TProductMapper productMapper;

    @Autowired
    private TShopMapper shopMapper;

    @Autowired
    private TImageMapper imageMapper;

    @Autowired
    private ProductClient productClient;

    @Override
    public ArrayList<Product> getAllProducts(Integer sid) {

        TShop shop = shopMapper.selectByPrimaryKey(sid);
        if(shop == null){
            throw new ShopNotFoundException("商店不存在");
        }

        ArrayList<Product> shopItem1s = new ArrayList<>();
        //ArrayList<TProduct> products = productMapper.selectBySid(sid);
        ArrayList<TProduct> products = productClient.getByShopId(sid).getData();
        for(TProduct product : products){
            String src = null;
            if(!imageMapper.selectByPid(product.getPid()).isEmpty()) {
                src = imageMapper.selectByPid(product.getPid()).getFirst().getImageSrc();
            }
            Product shopItem1 = new Product();
            shopItem1.setPid(product.getPid());
            shopItem1.setPrice(product.getPrice());
            shopItem1.setName(product.getProductName());
            shopItem1.setIsHot(false);
            if(product.getIsHot() == 1) shopItem1.setIsHot(true);
            shopItem1.setImageSrc(src);

            shopItem1s.add(shopItem1);
        }

        return shopItem1s;
    }

    @Override
    public ArrayList<Shop> getShopByKeywords(String keywords) {
        ArrayList<TShop> tShops = shopMapper.selectByKeywords(keywords);
        ArrayList<Shop> shops = new ArrayList<>();

        for(TShop tshop : tShops){
            shops.add(
                    new Shop(
                        tshop.getSid(),
                        tshop.getShopname(),
                        imageMapper.selectBySidLimit4(tshop.getSid()),
                        tshop.getFansNumber(),
                        shopMapper.getSaleCountBySid(tshop.getSid())
                    )
            );
        }

        return shops;
    }

    @Override
    public ShopInfo getShopInfoBySid(Integer sid) {
        TShop tShop = shopMapper.selectByPrimaryKey(sid);

        if(tShop == null){
            throw new ShopNotFoundException("商店不存在");
        }

        return new ShopInfo(
                tShop.getShopname(),
                tShop.getFansNumber(),
                shopMapper.getSaleCountBySid(tShop.getSid())
        );
    }

    @Override
    public void insertShop(TShop shop) {
        shopMapper.insert(shop);
    }

    @Override
    public TShop getShopBySid(Integer sid) {
        return shopMapper.selectByPrimaryKey(sid);
    }
}
