package com.soecode.lyf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/11 20:00
 */
@ControllerAdvice
public class BaseGlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult<Object> exceptionHandler(HttpServletRequest req, Exception e) {
        if (EmptyUtils.isNotEmpty(e.getMessage())&&e.getMessage().indexOf("提示") != -1) {
            return ResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
        return ResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务内部错误");
    }

    @ExceptionHandler(value = ParamInvalidException.class)
    @ResponseBody
    public ResponseResult<Object> paramInvalidExceptionHandler(HttpServletRequest req, ParamInvalidException e) throws Exception {
        return ResponseResult.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
