package com.powernode.mall.client;

import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service", url = "http://localhost:8890")
public interface UserClient {



    @RequestMapping("/users/get_by_uid")
    public JsonResult<TUser> getByUid(Integer uid);



}
