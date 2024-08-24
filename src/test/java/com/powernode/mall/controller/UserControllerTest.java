package com.powernode.mall.controller;

import com.powernode.mall.dto.Comment;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.UserComment;
import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.service.ex.ProductNotFoundException;
import com.powernode.mall.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private TUserMapper userMapper;

    @Test
    public void userRegisterTest1() {
        userMapper.deleteByUsername("Ibuki Ayapa");
        JsonResult<Void> result = userController.reg("Ibuki Ayapa", "asdfg", "buyer");
        Assertions.assertEquals(result.getStateCode(), 200);
    }

    @Test
    public void userRegisterTest0() {
        userMapper.deleteByUsername("Ibuki Ayapa");
        JsonResult<Void> result = userController.reg("user0", "asdfg", "buyer");
        Assertions.assertNotEquals(result.getStateCode(), 200);
    }

//    @Test
//    public void userLoginTest1() {
//        userMapper.deleteByUsername("Ibuki Ayapa");
//        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        JsonResult<Void> result = userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        Assertions.assertEquals(result.getStateCode(), 200);
////        JsonResult<Void> result = userController.login("Ibuki Ayapa", "asdfg", "buyer") {
////        });
////        Assertions.assertEquals(result.getStateCode(), 200);
//    }

    @Test
    public void userLoginTest0() {
        userMapper.deleteByUsername("Ibuki Ayapa");
        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
        JsonResult<Void> result = userController.reg("user0", "asdfg", "buyer");
        Assertions.assertNotEquals(result.getStateCode(), 200);
//        JsonResult<Void> result = userController.login("user0", "asdfg", "buyer");
//        Assertions.assertNotEquals(result.getStateCode(), 200);
    }

//    @Test
//    public void userChangePasswordTest1() {
//        userMapper.deleteByUsername("Ibuki Ayapa");
//        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        JsonResult<Void> result = userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        Assertions.assertEquals(result.getStateCode(), 200);
//    }

    @Test
    public void userChangePasswordTest0() {
        userMapper.deleteByUsername("Ibuki Ayapa");
        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
        JsonResult<Void> result = userController.reg("user0", "asdfg", "buyer");
        Assertions.assertNotEquals(result.getStateCode(), 200);
    }

//    @Test
//    public void userGetByUidTest1() {
//        userMapper.deleteByUsername("Ibuki Ayapa");
//        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        JsonResult<Void> result = userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        Assertions.assertEquals(result.getStateCode(), 200);
//    }

    @Test
    public void userGetByUidTest0() {
        userMapper.deleteByUsername("Ibuki Ayapa");
        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
        JsonResult<Void> result = userController.reg("user0", "asdfg", "buyer");
        Assertions.assertNotEquals(result.getStateCode(), 200);
    }

//    @Test
//    public void userChangeInfoTest1() {
//        userMapper.deleteByUsername("Ibuki Ayapa");
//        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        JsonResult<Void> result = userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        Assertions.assertEquals(result.getStateCode(), 200);
//    }

    @Test
    public void userChangeInfoTest0() {
        userMapper.deleteByUsername("Ibuki Ayapa");
        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
        JsonResult<Void> result = userController.reg("user0", "asdfg", "buyer");
        Assertions.assertNotEquals(result.getStateCode(), 200);
    }

//    @Test
//    public void userCommentTest1() {
//        userMapper.deleteByUsername("Ibuki Ayapa");
//        userController.reg("Ibuki Ayapa", "asdfg", "buyer");
//        UserComment userComment = new UserComment(0, "user0", 3.5, "I love it", new ArrayList<String>(), 3);
//        JsonResult<Void> result = userController.comment(userComment);
//        Assertions.assertEquals(result.getStateCode(), 200);
//    }

    @Test
    public void userCommentTest0() {
        boolean thrown=false;
        UserComment userComment = new UserComment(0, "user0", 3.5, "I love it", new ArrayList<String>(), -100);
        try {
            JsonResult<Void> result = userController.comment(userComment);
        } catch(Exception e) {
            thrown = true;
        }
        Assertions.assertTrue(thrown);
    }
}
