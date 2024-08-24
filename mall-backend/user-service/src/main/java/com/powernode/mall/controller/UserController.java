package com.powernode.mall.controller;

import com.powernode.mall.dto.UserComment;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.IUserService;
import com.powernode.mall.service.ex.InsertException;
import com.powernode.mall.service.ex.UsernameDuplicateException;
import com.powernode.mall.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("users")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    //@ResponseBody // 表示此方法的响应结果以json格式进行数据响应给到前端
    public JsonResult<Void> reg(String username, String password, String type)
    {
        // 创建响应结果对象
        JsonResult<Void> result = new JsonResult<>();
        try
        {
            TUser user = new TUser();
            user.setUsername(username);
            user.setPassword(password);
            user.setType(type);

            userService.reg(user);
            result.setStateCode(200);
            result.setStateMsg("用户注册成功");
        } catch (UsernameDuplicateException e)
        {
            result.setStateCode(4000);
            result.setStateMsg("用户名被占用");

            //throw new RuntimeException(e);
        } catch (InsertException e)
        {
            result.setStateCode(5000);
            result.setStateMsg("注册时产生未知异常");

        }
        return result;

    }

    @RequestMapping("login")
    public JsonResult<TUser> login(String username, String password, String type, HttpSession session){
        TUser user = userService.login(username, password, type);


        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());

        return new JsonResult<TUser>(OK, user);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<Void>(OK);
    }

    @GetMapping("get_by_uid")
    public JsonResult<TUser> getByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        TUser user = userService.getByUid(uid);
        return new JsonResult<TUser>(OK, user);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(@RequestBody TUser user, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("comment")
    public JsonResult<Void> comment(@RequestBody UserComment userComment){
        userService.comment(userComment);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<TUser> getByUid(Integer uid){
        TUser user = userService.getByUid(uid);
        return new JsonResult<>(OK, user);
    }
}
