package com.bobo.dealcontroller.config;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionControllerAdvice {
    /**
     *
     * @param e 全局异常处理。返回校检的错误提示
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public ResultVO<String > ApiExceptionHandler(ApiException e){
        return new ResultVO<>(e.getCode(), "响应失败", e.getMsg());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里返回类型是自定义响应体
        return new ResultVO<>(1001, "参数校验失败", objectError.getDefaultMessage());
    }
}
