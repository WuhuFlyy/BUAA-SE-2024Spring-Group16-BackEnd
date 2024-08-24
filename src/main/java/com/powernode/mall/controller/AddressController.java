package com.powernode.mall.controller;

import com.powernode.mall.dto.Address;
import com.powernode.mall.service.IAddressService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("address")
@CrossOrigin(origins="*")
public class AddressController extends BaseController {
    @Autowired
    IAddressService addressService;

    @RequestMapping("add")
    public JsonResult<Void> add(String username, String name, String address, String phone){
        addressService.addAddress(username, name, address, phone);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("delete")
    public JsonResult<Void> delete(int id){
        addressService.deleteAddressById(id);
        return new JsonResult<>(OK);
    }

    @RequestMapping("list")
    public JsonResult<ArrayList<Address>> getAddressByUid(String username){
        ArrayList<Address> addresses = addressService.listAddressByUid(username);
        return new JsonResult<ArrayList<Address>>(OK, addresses);
    }
}
