package com.yoona.quick_start.common.exception;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/16
 * @Time: 4:58 下午
 * @Msg:
 */
public class ParamErrorException extends RuntimeException{


    public ParamErrorException() {
    }

    public ParamErrorException(String message) {
        super(message);
    }
}
