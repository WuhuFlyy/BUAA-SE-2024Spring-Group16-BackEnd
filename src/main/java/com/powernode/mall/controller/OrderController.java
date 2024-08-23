package com.powernode.mall.controller;

import com.powernode.mall.po.TAddress;
import com.powernode.mall.service.IOrderService;
import com.powernode.mall.service.impl.OrderServiceImpl;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@CrossOrigin(origins="*")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("submit")
    public JsonResult<Integer> submit(String username, Integer pid, String version, Integer quantity, Integer aid) {
        Integer ret = orderService.submitOrder(username, pid, version, quantity, aid);
        return new JsonResult<Integer>(OK, ret);
    }
}
