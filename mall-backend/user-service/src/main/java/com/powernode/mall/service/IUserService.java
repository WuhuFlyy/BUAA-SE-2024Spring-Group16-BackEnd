package com.powernode.mall.service;

import com.powernode.mall.dto.UserComment;
import com.powernode.mall.po.TUser;

public interface IUserService
{
    /**
     * 用户注册方法
     * @param user 用户数据对象
     */
    void reg(TUser user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户数据
     */
    TUser login(String username, String password, String type);

    /**
     * 修改密码
     * @param uid 当前用户id
     * @param username 用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 获取当前用户信息
     * @param uid 当前用户
     * @return 当前用户信息
     */
    TUser getByUid(Integer uid);

    /**
     * 修改用户资料
     * @param uid 对象用户id
     * @param username 当前用户用户名
     * @param user 修改的用户数据
     */
    void changeInfo(Integer uid, String username, TUser user);

    /**
     * 用户发表评价
     * @param userComment 评价内容
     */
    void comment(UserComment userComment);
}
