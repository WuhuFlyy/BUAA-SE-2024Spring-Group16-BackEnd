package com.powernode.mall.service;

import com.powernode.mall.dto.Address;
import com.powernode.mall.po.TAddress;

import java.util.ArrayList;

public interface IAddressService {
    int addAddress(String username, String name, String address, String phone);
    int deleteAddressById(int id);
    ArrayList<Address> listAddressByUid(String username);
}
