package com.ketai.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:长沙科泰梦想学院
 * @Description:
 * @Date:Create In 2021/12/18 16:29
 **/

@Data
@ApiModel(value = "UserBO",description = "用户注册信息")
public class UserBO {

    @ApiModelProperty(value = "用户账号")
    private String userCode;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String userPassword;
}
