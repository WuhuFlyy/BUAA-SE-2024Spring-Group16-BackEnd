package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.UsernameDuplicateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    IUserService userService;

    @Autowired
    TUserMapper userMapper;

    @Test
    public void regServiceTest1() {
        TUser user = new TUser();
        user.setUsername("newUser123");
        user.setPassword("123456");
        user.setType("buyer");
        userMapper.insert(user);
        userService.reg(user);
        TUser u = userMapper.selectByUsername(user.getUsername());
        Assertions.assertNotNull(u);
        userMapper.deleteByPrimaryKey(u.getUid());
    }

    @Test
    public void regServiceTest0() {
        TUser user = new TUser();
        user.setUsername("user2");
        user.setPassword("123456");
        user.setType("buyer");
        userMapper.insert(user);

        boolean thrown=false;
        try {
            userService.reg(user);
        }catch (UsernameDuplicateException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }
}
