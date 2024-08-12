package com.powernode.mall.service;

import com.powernode.mall.po.TOrder;

public interface IOrderService {

    Integer submitOrder(String username, Integer pid, String version, Integer quantity);
}
