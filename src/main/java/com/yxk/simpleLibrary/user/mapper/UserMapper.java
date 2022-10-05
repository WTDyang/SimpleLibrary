package com.yxk.simpleLibrary.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxk.simpleLibrary.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    User getUserByUsername(@Param("username") String username);

    int regist(@Param("user") User user);

    int isUnique(@Param("email") String email,@Param("username") String username);

}