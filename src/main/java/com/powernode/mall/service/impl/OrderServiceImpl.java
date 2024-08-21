package com.powernode.mall.service.impl;

import com.powernode.mall.mapper.*;
import com.powernode.mall.po.*;
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
    public Integer submitOrder(String username, Integer pid, String version, Integer quantity, Integer aid) {

        TUser user = userMapper.selectByUsername(username);

        Date date = new Date();
        TOrder order = new TOrder();
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

        order.setOrderTime(date);
        order.setAid(aid);
        order.setCreatedUser(username);
        order.setCreatedTime(date);
        order.setModifiedUser(username);
        order.setModifiedTime(date);
        order.setUid(userMapper.selectByUsername(username).getUid());
        order.setPayTime(date);
        order.setQuantity(quantity);
        order.setVersion(version);
        order.setStatus(1);
        order.setTotalPrice(product.getPrice() * quantity);
        orderMapper.insert(order);

        return order.getOid();
    }
}
