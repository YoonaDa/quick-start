package com.yoona.quick_start.common.exception;

import com.yoona.quick_start.common.enums.CommonEnums;
import com.yoona.quick_start.common.response.SystemResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/16
 * @Time: 11:47 上午
 * @Msg: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获异常
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public SystemResponse exceptionHandler(Exception e){
        log.error("未知异常!原因是{}",e.getMessage());
        e.printStackTrace();
        return SystemResponse.response(CommonEnums.INTERNAL_SERVER_ERROR,e.getMessage());
    }

    /**
     * 缺少参数异常
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public SystemResponse paramMiss(MissingServletRequestParameterException e){
        log.error("",e);
        return new SystemResponse(CommonEnums.PARAM_ERROR.getCode(),e.getParameterName()+"is required !");
    }

    /**
     * 缺少请求体异常
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public SystemResponse paramBodyMiss(HttpMessageNotReadableException e){
        log.error("",e);
        return new SystemResponse(CommonEnums.PARAM_ERROR.getCode(),"request body is required !");
    }

    /**
     * 参数校验异常
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public SystemResponse paramValid(MethodArgumentNotValidException e){
        log.error("",e);
        //获取异常信息
        BindingResult exceptions = e.getBindingResult();
        //判断异常中是否有错误信息，如果存在就使用异常中的消息
        if(exceptions.hasErrors()){
            List<ObjectError> errors = exceptions.getAllErrors();
            if(!errors.isEmpty()){
                //这里列出了全部错误参数，按正常逻辑取第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return new SystemResponse(CommonEnums.PARAM_ERROR.getCode(),fieldError.getDefaultMessage());
            }
        }
        return new SystemResponse(CommonEnums.PARAM_ERROR);
    }

    /**
     * 自定义参数异常
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ParamErrorException.class})
    public SystemResponse paramException(ParamErrorException e){
        log.error("",e);
        if(!StringUtils.isEmpty(e.getMessage())){
            return new SystemResponse(CommonEnums.PARAM_ERROR.getCode(),e.getMessage());
        }
        return new SystemResponse(CommonEnums.PARAM_ERROR);
    }

}
