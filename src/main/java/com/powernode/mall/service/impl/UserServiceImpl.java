package com.powernode.mall.service.impl;


import com.powernode.mall.mapper.TUserMapper;
import com.powernode.mall.po.TUser;
import com.powernode.mall.service.IUserService;
import com.powernode.mall.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.ThreadPoolTaskSchedulerBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private ThreadPoolTaskSchedulerBuilder threadPoolTaskSchedulerBuilder;

    @Override
    public void reg(TUser user){
        // 先检测用户名是否重复
        String username = user.getUsername();
        TUser result = userMapper.selectByUsername(username);
        if(result != null){
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }
        // 密码加密
        // 串+password+串 整体md5算法加密
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(user.getPassword(), salt);
        user.setPassword(md5Password);
        // 补全数据：盐值
        user.setSalt(salt);

        // 数据补全
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        // 执行注册业务(row==1)
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("用户注册过程中产生未知异常！");
        }


    }

    /**
     * 执行密码加密
     * @param password 原始密码
     * @param salt 盐值
     * @return 加密后的密文
     */
    private String getMd5Password(String password, String salt)
    {
        /*
         * 加密规则：
         * 1、无视原始密码的强度
         * 2、使用UUID作为盐值，在原始密码的左右两侧拼接
         * 3、循环加密3次
         */
        for (int i = 0; i < 3; i++)
        {
            password = DigestUtils.md5DigestAsHex((salt + password +
                    salt).getBytes()).toUpperCase();
        }
        return password;
    }

    @Override
    public TUser login(String username, String password, String type) {
        TUser user = userMapper.selectByUsername(username);
        if(user == null || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户不存在！");
        }

        String salt = user.getSalt();
        String md5Password = getMd5Password(password, salt);

        if(!user.getType().equals(type)){
            throw new UserTypeNotMatchException("登录类型错误");
        }

        if(!md5Password.equals(user.getPassword())){
            throw new PasswordNotMatchException("密码验证失败！");
        }

        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        TUser user = userMapper.selectByPrimaryKey(uid);
        if(user == null || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }

        String salt = user.getSalt();
        String oldMd5Password = getMd5Password(oldPassword, salt);
        if(!oldMd5Password.equals(user.getPassword())){
            throw new PasswordNotMatchException("密码错误");
        }

        String newMd5Password = getMd5Password(newPassword, salt);
        Date now = new Date();

        user.setPassword(newMd5Password);
        user.setModifiedTime(now);
        Integer rows = userMapper.updateByPrimaryKey(user);
        if (rows != 1){
            throw new UpdateException("更新密码时发生数据库错误");
        }
    }

    public TUser getByUid(Integer uid) {
        TUser user = userMapper.selectByPrimaryKey(uid);
        if(user == null || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户不存在");
        }

        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, TUser newUser){
        TUser user = userMapper.selectByPrimaryKey(uid);
        if(user == null || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户不存在");
        }



        if(!username.equals(newUser.getUsername())){
            if(userMapper.selectByUsername(newUser.getUsername()) != null){
                throw new UsernameDuplicateException("尝试更改的用户名[" + username + "]已经被占用");
            }

            if(newUser.getUsername() != null){
                user.setUsername(newUser.getUsername());
            }
        }

        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        user.setGender(newUser.getGender());
        user.setModifiedUser(newUser.getUsername());

        Integer rows = userMapper.updateByPrimaryKey(user);
        if(rows != 1){
            throw new UpdateException("更新数据时出现未知错误");
        }
    }
}
