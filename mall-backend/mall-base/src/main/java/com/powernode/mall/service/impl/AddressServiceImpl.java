package com.powernode.mall.service.impl;

import com.powernode.mall.dto.Address;
import com.powernode.mall.mapper.TAddressMapper;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.po.TAddress;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.IAddressService;
import com.powernode.mall.service.ex.AddressNotFoundException;
import com.powernode.mall.service.ex.DeleteException;
import com.powernode.mall.service.ex.InsertException;
import com.powernode.mall.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    TAddressMapper addressMapper;

    @Autowired
    TUserMapper userMapper;

    @Override
    public int addAddress(String username, String name, String address, String phone) {
        TUser tUser = userMapper.selectByUsername(username);
        if(tUser == null){
            throw new UserNotFoundException("用户不存在");
        }
        TAddress tAddress = new TAddress();
        tAddress.setAddress(address);
        tAddress.setPhone(phone);
        tAddress.setName(name);
        tAddress.setUid(tUser.getUid());
        tAddress.setCreatedUser(tUser.getUsername());
        tAddress.setCreatedTime(new Date());
        tAddress.setModifiedUser(tUser.getUsername());
        tAddress.setModifiedTime(new Date());

        int row = addressMapper.insert(tAddress);
        if(row != 1){
            throw new InsertException("插入数据时发生数据库错误");
        }
        return row;
    }

    @Override
    public int deleteAddressById(int id) {
        int row = addressMapper.deleteByPrimaryKey(id);
        if(row == 0){
            throw new AddressNotFoundException("收货地址不存在");
        }
        if(row != 1){
            throw new DeleteException("删除数据时发生数据库错误");
        }
        return row;
    }

    @Override
    public ArrayList<Address> listAddressByUid(String username) {

        TUser tUser = userMapper.selectByUsername(username);
        if(tUser == null){
            throw new UserNotFoundException("用户不存在");
        }
        int uid = tUser.getUid();

        ArrayList<TAddress> tAddresses = addressMapper.selectByUid(uid);
        ArrayList<Address> addresses = new ArrayList<>();
        for (TAddress tAddress : tAddresses) {
            Address address = new Address();
            address.setAddress(tAddress.getAddress());
            address.setPhone(tAddress.getPhone());
            address.setName(tAddress.getName());
            address.setAid(tAddress.getAid());
            addresses.add(address);
        }
        return addresses;
    }
}
