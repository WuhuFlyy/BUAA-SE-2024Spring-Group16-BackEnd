package com.powernode.mall.client.fallback;

import com.powernode.mall.client.UserClient;
import com.powernode.mall.po.TUser;
import com.powernode.mall.util.JsonResult;

public class UserClientFallback implements UserClient {
    @Override
    public JsonResult<TUser> getByUid(Integer uid) {
        return new JsonResult<>(200, new TUser());
    }
}
