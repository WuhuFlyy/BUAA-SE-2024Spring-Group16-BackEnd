package com.powernode.mall.client;

import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service", url = "http://localhost:8890")
public interface UserClient {

    @RequestMapping("/users/reg")
    public JsonResult<Void> reg(String username, String password, String type);

    @RequestMapping("users/login")
    public JsonResult<Void> login(String username, String password);

    @RequestMapping("users/get_by_uid")
    public JsonResult<TUser> getByUid(Integer uid);



}
