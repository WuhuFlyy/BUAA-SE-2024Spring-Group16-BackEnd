package com.powernode.mall.service.impl;

import com.powernode.mall.client.ProductClient;
import com.powernode.mall.client.UserClient;
import com.powernode.mall.dto.Cart;
import com.powernode.mall.mapper.TCartMapper;
import com.powernode.mall.mapper.TProductMapper;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.mapper.TVersionMapper;
import com.powernode.mall.po.TCart;
import com.powernode.mall.po.TProduct;
import com.powernode.mall.po.TUser;
import com.powernode.mall.po.TVersion;
import com.powernode.mall.service.ICartService;
import com.powernode.mall.service.IUserService;
import com.powernode.mall.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    TUserMapper userMapper;

    @Autowired
    TCartMapper cartMapper;

    @Autowired
    TProductMapper productMapper;

    @Autowired
    TVersionMapper versionMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public void addToCart(String username, Integer pid, String version, Integer quantity) {
        //TUser user = userMapper.selectByUsername(username);
        TUser user = userClient.getByUsername(username).getData();
        TCart cart = new TCart();
        Date date = new Date();
        //TProduct product = productMapper.selectByPrimaryKey(pid);
        TProduct product = productClient.getByPid(pid).getData();
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

        cart.setModifiedUser(username);
        cart.setModifiedTime(date);
        cart.setCreatedUser(username);
        cart.setCreatedTime(date);
        cart.setPid(pid);
        cart.setVersion(version);
        cart.setQuantity(quantity);
        cart.setUid(user.getUid());

        cartMapper.insert(cart);
    }

    @Override
    public void addNum(int cid) {
        cartMapper.addNumByCid(cid);
    }

    @Override
    public void reduceNum(int cid) {
        TCart cart = cartMapper.selectByPrimaryKey(cid);
        if(cart.getQuantity() == 0){
            throw new CannotReduceQuantityException("数量为0，不能减少数量");
        }
        cartMapper.reduceNumByCid(cid);
    }

    @Override
    public void deleteCart(int cid) {
        cartMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public ArrayList<Cart> getCartByUsername(String username) {
        ArrayList<Cart> carts = new ArrayList<>();
        ArrayList<TCart> tCarts = cartMapper.selectByUsername(username);
        System.out.println(tCarts);
        for(TCart tcart : tCarts) {
            TProduct product = productMapper.selectByPrimaryKey(tcart.getPid());
            Cart cart = new Cart();
            cart.setCid(tcart.getCid());
            cart.setProductId(tcart.getPid());
            cart.setProductName(product.getProductName());
            cart.setSalePrice(product.getPrice());
            cart.setSelectedVersion(tcart.getVersion());
            cart.setQuantity(tcart.getQuantity());
            cart.setTotal(product.getPrice()*tcart.getQuantity());
            carts.add(cart);
        }
        return carts;
    }
}
