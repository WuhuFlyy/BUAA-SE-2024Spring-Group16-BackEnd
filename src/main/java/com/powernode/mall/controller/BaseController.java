package com.powernode.mall.controller;


import com.powernode.mall.service.ex.*;
import com.powernode.mall.service.ex.UsernameDuplicateException;
import com.powernode.mall.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

@CrossOrigin(origins="*")
/* 控制层类的基类 */
public class BaseController
{
    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<Void>(e);
        if(e instanceof UsernameDuplicateException){
            result.setStateCode(4000);
        }
        else if(e instanceof UserNotFoundException){
            result.setStateCode(4001);
        }
        else if(e instanceof PasswordNotMatchException){
            result.setStateCode(4002);
        }
        else if(e instanceof AddressCountLimitException){
            result.setStateCode(4003);
        }
        else if (e instanceof AddressNotFoundException) {
            result.setStateCode(4004);
        }
        else if (e instanceof AccessDeniedException) {
            result.setStateCode(4005);
        }
        else if(e instanceof ProductNotFoundException){
            result.setStateCode(4006);
        }
        else if(e instanceof CartNotFoundException){
            result.setStateCode(4007);
        }
        else if(e instanceof FavoriteNotFoundException){
            result.setStateCode(4008);
        }
        else if(e instanceof UserTypeNotMatchException){
            result.setStateCode(4009);
        }
        else if(e instanceof ProductNoMatchingShopException){
            result.setStateCode(4010);
        }

        else if(e instanceof ShopNotFoundException){
            result.setStateCode(4011);
        }

        else if(e instanceof ShopDuplicateException){
            result.setStateCode(4012);
        }

        else if(e instanceof ShopInfoNotCompleteException){
            result.setStateCode(4013);
        }

        else if(e instanceof InsufficientStorageException){
            result.setStateCode(4014);
        }

        else if(e instanceof VersionNotFoundException){
            result.setStateCode(4015);
        }

        else if(e instanceof InsertException){
            result.setStateCode(5000);
        }
        else if(e instanceof UpdateException){
            result.setStateCode(5001);
        }

        else if(e instanceof DeleteException){
            result.setStateCode(5002);
        }
        return result;
    }

    /**
     * 从HttpSession对象中获取uid
     * @param session HttpSession对象
     * @return 当前登录的用户的id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从HttpSession对象中获取用户名
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    /**
     * 从HttpSession对象中获取uid
     *
     * @param session HttpSession对象
     * @return 当前登录的用户的id
     */
    protected final Integer getSidFromSession(HttpSession session)
    {
        return Integer.valueOf(session.getAttribute("sid").toString());
    }

}
