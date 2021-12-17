package com.ketai.commom;

import com.ketai.commom.exception.DaoException;
import com.ketai.commom.exception.ServiceException;
import com.ketai.commom.exception.SysException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:长沙科泰梦想学院
 * @Description:
 * @Date:Create In 2021/12/17 21:38
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public R error (Exception e) {

        return R.error(ErrorCodeEnum.SYSTEM_EXECUTION_ERROR);
    }

    /*** 捕获异常 * @param e 异常类型为 ServiceException * @return */
    @ExceptionHandler(value = ServiceException.class)
    public R error (ServiceException e) {

        return R.error(e.getErrorCode(), e.getMessage());
    }

    /*** 捕获异常 * @param e 异常类型为 DaoException * @return */
    @ExceptionHandler(value = DaoException.class)
    public R error (DaoException e) {

        return R.error(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = SysException.class)
    public R error (SysException e) {

        return R.error(e.getErrorCode(), e.getMessage());
    }
}
