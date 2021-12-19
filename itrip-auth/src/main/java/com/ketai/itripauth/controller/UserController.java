package com.ketai.itripauth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.bo.UserBO;
import com.ketai.commom.ErrorCodeEnum;
import com.ketai.commom.R;
import com.ketai.itripauth.services.UserService;
import com.ketai.pojo.ItripUser;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:长沙科泰梦想学院
 * @Description:
 * @Date:Create In 2021/12/18 15:04
 **/

@RestController
@RequestMapping("/api/")
public class UserController {


    @Resource
    private UserService  userService;

    @GetMapping(value = "/ckusr")
    public R checkUser(String name) {
       ItripUser  user= userService.checkUser(name);
        return  R.ok(user);
    }


    //'/auth/api/doregister'
    @PostMapping("/doregister")
    public  R   Register(UserBO  bo){
         //  double  check
        userService.registerUser(bo);


        return R.ok();
    }


}
