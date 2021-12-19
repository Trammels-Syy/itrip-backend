package com.ketai.commom.exception;


import com.ketai.commom.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author mo
 * @Description: 自定义异常
 * @date 2020-09-02 10:48
 */
@Data
@ApiModel(value = "自定义service层异常")
public class ServiceException extends RuntimeException {

    @ApiModelProperty(value = "异常状态码")
    private String errorCode;

    public ServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.errorCode = errorCodeEnum.getErrorCode();
    }


}
