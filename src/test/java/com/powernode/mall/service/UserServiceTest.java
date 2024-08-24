package com.powernode.mall.service;

import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.UserComment;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.ex.PasswordNotMatchException;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.service.ex.UsernameDuplicateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;

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

        boolean thrown=false;
        try {
            userService.reg(user);
        }catch (UsernameDuplicateException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void loginServiceTest1() {
        userMapper.deleteByUsername("小明");
        TUser user = new TUser();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setType("buyer");
        userService.reg(user);
        TUser u = userService.login("小明","123456","buyer");
        Assertions.assertNotNull(u);
        userMapper.deleteByPrimaryKey(u.getUid());
    }

    @Test
    public void loginServiceTest0() {
        userMapper.deleteByUsername("小明");
        TUser user = new TUser();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setType("buyer");
        userService.reg(user);
        boolean thrown=false;
        try {
            TUser u = userService.login("小明", "12345", "buyer");
        }catch (PasswordNotMatchException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
        userMapper.deleteByUsername("小明");
    }

    @Test
    public void changePasswordServiceTest1() {
        userMapper.deleteByUsername("小明");
        TUser user = new TUser();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setType("buyer");
        userService.reg(user);
        TUser u = userMapper.selectByUsername(user.getUsername());
        userService.changePassword(u.getUid(),u.getUsername(),"123456","654321");

        boolean thrown=false;
        try {
            userService.login(u.getUsername(),"654321", "buyer");
        }catch (PasswordNotMatchException e){
            thrown=true;
        }
        Assertions.assertFalse(thrown);
        userMapper.deleteByPrimaryKey(u.getUid());
    }

    @Test
    public void changePasswordServiceTest0() {
        userMapper.deleteByUsername("小明");
        TUser user = new TUser();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setType("buyer");
        userService.reg(user);
        boolean thrown=false;
        TUser u = userMapper.selectByUsername(user.getUsername());
        try {
            userService.changePassword(u.getUid(), u.getUsername(), "1234567", "654321");
        }catch (PasswordNotMatchException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void changeInfoServiceTest1() {
        userMapper.deleteByUsername("小明");
        TUser user = new TUser();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setType("buyer");
        userService.reg(user);
        TUser u = userMapper.selectByUsername(user.getUsername());
        TUser a = new TUser();
        a.setUsername("user30");
        userService.changeInfo(u.getUid(),u.getUsername(),a);

        Assertions.assertNotNull(userMapper.selectByUsername("user30"));

        userMapper.deleteByUsername("user30");
    }

    @Test
    public void changeInfoServiceTest0() {
        userMapper.deleteByUsername("小明");
        TUser user = new TUser();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setType("buyer");
        userService.reg(user);
        TUser a = new TUser();
        a.setUsername("user3");
        boolean thrown=false;
        TUser u = userMapper.selectByUsername(user.getUsername());
        try {
            userService.changeInfo(u.getUid(),u.getUsername(),a);
        }catch (UsernameDuplicateException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

    @Test
    public void commentServiceTest1() {

        UserComment userComment = new UserComment();
        ArrayList<String> i = new ArrayList<>();
        i.add("1");i.add("2");

        userComment.setId(1);
        userComment.setUserName("user0");
        userComment.setContent("good");
        userComment.setRate(3.5);
        userComment.setProductId(3);
        userComment.setImages(i);

        boolean thrown=false;
        try{
            userService.comment(userComment);
        }catch (Exception e){
            thrown=true;
        }
        Assertions.assertFalse(thrown);
    }

    @Test
    public void commentServiceTest0() {
        UserComment userComment = new UserComment();
        ArrayList<String> i = new ArrayList<>();
        i.add("1");i.add("2");

        userComment.setId(1);
        userComment.setUserName("user0");
        userComment.setContent("good");
        userComment.setRate(3.5);
        userComment.setProductId(30000);
        userComment.setImages(i);

        boolean thrown=false;
        try{
            userService.comment(userComment);
        }catch (ProductNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }

}
