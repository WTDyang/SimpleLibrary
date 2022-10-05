package com.yxk.simpleLibrary.user.controller;


import com.yxk.simpleLibrary.common.ResultCode;
import com.yxk.simpleLibrary.common.ResultJson;
import com.yxk.simpleLibrary.user.entity.User;
import com.yxk.simpleLibrary.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yxk.simpleLibrary.common.constant.Constants;
import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/toMain")
    public String toMain(){
        System.out.println("跳转");
        return "redirect:main.html";
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录")
    public ResultJson login(@Valid @RequestBody User user){
        if(this.userService.login(user) == Constants.SUCCESS){
            return ResultJson.success(user);
        }
        return ResultJson.failure(ResultCode.LOGIN_ERROR);
    }

    @PostMapping(value = "/regist", produces = "application/json")
    @ApiOperation(value = "用户注册")
    public ResultJson regist(@Valid @RequestBody User user){
        if(this.userService.regist(user) == Constants.SUCCESS){
            return ResultJson.success();
        }else{
            return ResultJson.failure(ResultCode.USERNAME_OR_EMAIL_EXIST);
        }
    }

}
