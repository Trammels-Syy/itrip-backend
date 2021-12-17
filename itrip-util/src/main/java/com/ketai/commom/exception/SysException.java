package com.ketai.commom.exception;

import com.cskt.common.constants.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author mo
 * @Description: 系统自定义异常
 * @date 2020-09-02 15:20
 */
@Data
@ApiModel(value = "自定义系统异常")
public class SysException extends RuntimeException {

    @ApiModelProperty(value = "异常编码")
    private String errorCode;

    public SysException(String message,String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public SysException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.errorCode = errorCodeEnum.getErrorCode();
    }
}
