package com.yxk.simpleLibrary.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxk.simpleLibrary.user.entity.User;

public interface IUserService extends IService<User> {

    public int login(User user);

    public int regist(User user);


}
