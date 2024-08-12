package com.powernode.mall.service.impl;

import com.powernode.mall.mapper.*;
import com.powernode.mall.po.TCart;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.po.TUser;
import com.powernode.mall.po.TVersion;
import com.powernode.mall.service.IOrderService;
import com.powernode.mall.service.ex.InsufficientStorageException;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.UserNotFoundException;
import com.powernode.mall.service.ex.VersionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    TUserMapper userMapper;

    @Autowired
    TOrderMapper orderMapper;

    @Autowired
    TProductMapper productMapper;

    @Autowired
    TVersionMapper versionMapper;

    @Override
    public Integer submitOrder(String username, Integer pid, String version, Integer quantity) {

        TUser user = userMapper.selectByUsername(username);
        TCart cart = new TCart();
        Date date = new Date();
        TProduct product = productMapper.selectByPrimaryKey(pid);
        ArrayList<TVersion> versions = versionMapper.selectByPid(pid);
        int tag = 0;

        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        if (product == null) {
            throw new ProductNotFoundException("商品不存在");
        }

        if(quantity > product.getStorage()) {
            throw new InsufficientStorageException("库存不足");
        }

        for(TVersion v : versions) {
            if(v.getVersion().equals(version)) {
                tag = 1;
                break;
            }
        }

        if(tag == 0){
            throw new VersionNotFoundException("所选版本不存在");
        }
        
        return null;
    }
}
