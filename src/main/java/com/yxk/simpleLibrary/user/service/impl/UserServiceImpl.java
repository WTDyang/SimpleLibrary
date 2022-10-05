package com.yxk.simpleLibrary.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxk.simpleLibrary.user.entity.User;
import com.yxk.simpleLibrary.user.mapper.UserMapper;
import com.yxk.simpleLibrary.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.yxk.simpleLibrary.common.constant.Constants.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {

    //密码编码器
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @MethodName: loadUserByUsername
     * @Description: UserDetailsService接口下方法 根据用户名找到用户
     * @Author: yxk
     * @Date: 2021/6/11 15:09
     * @Param: [username]
     * @Return: org.springframework.security.core.userdetails.UserDetails
     **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据传入Username查询出数据库中对应用户
        User user = baseMapper.getUserByUsername(username);
        //找不到相应用户则抛出异常
        if(user == null){
            throw new UsernameNotFoundException("用户名或密码未找到");
        }
        return user;
    }


    /**
     * @MethodName: login
     * @Description: 登录验证方法
     * @Author: yxk
     * @Date: 2021/6/11 14:09
     * @Param: [user]
     * @Return: int
     **/
    @Override
    public int login(User user){
        //密码匹配
        if(passwordEncoder.matches(user.getPassword(),loadUserByUsername(user.getUsername()).getPassword())){
            return SUCCESS;
        }
        return FAILURE;
    }
    /**
     * @MethodName: regist
     * @Description: 注册方法
     * @Author: yxk
     * @Date: 2021/6/11 16:02
     * @Param: [user]
     * @Return: int
     **/
    @Override
    public int regist(User user) {
        //判断数据空中是否已经存在用户键入邮箱或用户名
        if(this.baseMapper.isUnique(user.getEmail(),user.getUsername()) > 0){
            return USERNAME_OR_EMAIL_EXIST;
        }
        //设置时间为当前时间
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        //密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            this.baseMapper.regist(user);
        }catch(DuplicateKeyException e){
            log.error(e.toString());
            return USERNAME_OR_EMAIL_EXIST;
        }
        return SUCCESS;
    }

}
