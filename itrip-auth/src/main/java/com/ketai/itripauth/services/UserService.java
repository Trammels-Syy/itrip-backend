package com.ketai.itripauth.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.bo.UserBO;
import com.ketai.pojo.ItripUser;

/**
 * @Author:长沙科泰梦想学院
 * @Description:
 * @Date:Create In 2021/12/18 15:20
 **/
public interface UserService extends IService<ItripUser> {

    public ItripUser  checkUser(String  userName);

    ItripUser registerUser (UserBO bo);

}
