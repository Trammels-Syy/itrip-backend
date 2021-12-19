package com.ketai.itripauth.services.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.bo.UserBO;
import com.ketai.commom.ErrorCodeEnum;
import com.ketai.commom.R;
import com.ketai.commom.exception.ServiceException;
import com.ketai.itripauth.services.UserService;
import com.ketai.mapper.ItripUserMapper;
import com.ketai.pojo.ItripUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author:长沙科泰梦想学院
 * @Description:
 * @Date:Create In 2021/12/18 15:21
 **/
@Service
public class UserServiceImpl extends ServiceImpl<ItripUserMapper, ItripUser> implements UserService {
    @Override
    public ItripUser checkUser (String userName) {

        if (!StringUtils.hasLength(userName)) {
            //参数为空
            throw new ServiceException(ErrorCodeEnum.AUTH_PARAMETER_IS_EMPTY);
        }
        QueryWrapper<ItripUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_code", userName);
        ItripUser user = this.getOne(queryWrapper);
        if (user != null) {
            //当用户数据不为空的时候，校验不通过
            throw new ServiceException(ErrorCodeEnum.AUTH_USER_ALREADY_EXISTS);
        }
        return user;
    }

    @Override
    public ItripUser registerUser (UserBO bo) {
        if (!StringUtils.hasLength(bo.getUserCode())) {
            //参数为空
            throw new ServiceException(ErrorCodeEnum.AUTH_PARAMETER_IS_EMPTY);
        } else if (!StringUtils.hasLength(bo.getUserCode())) {
            throw new ServiceException(ErrorCodeEnum.AUTH_PARAMETER_ERROR);
        } else if (!StringUtils.hasLength(bo.getUserName())) {
            // 用户名为空
            throw new ServiceException(ErrorCodeEnum.AUTH_PARAMETER_IS_EMPTY);
        }

        // 对密码进行加密
        String md5Password = SecureUtil.md5(bo.getUserPassword());
        // 给用户对象属性重新赋值
        bo.setUserPassword(md5Password);
        ItripUser user = new ItripUser();
        BeanUtils.copyProperties(bo, user);
        baseMapper.insert(user);
        return user;
    }
}
