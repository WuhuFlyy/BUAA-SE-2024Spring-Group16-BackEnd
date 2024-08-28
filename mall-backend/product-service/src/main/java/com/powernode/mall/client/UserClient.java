package com.powernode.mall.client;

import com.powernode.mall.client.fallback.UserClientFallback;
import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8890", fallback = UserClientFallback.class)
public interface UserClient {
    @RequestMapping("/users/get_by_uid")
    JsonResult<TUser> getByUid(@RequestParam Integer uid);
}
