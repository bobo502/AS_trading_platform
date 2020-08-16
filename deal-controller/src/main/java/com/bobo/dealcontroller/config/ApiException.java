package com.bobo.dealcontroller.config;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private int code;
    private String msg;

    public ApiException(){
        this(1001,"接口错误！");
    }

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public ApiException(String msg){
        this(1001,msg);
    }
}
