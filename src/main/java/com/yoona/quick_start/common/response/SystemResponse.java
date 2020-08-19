package com.yoona.quick_start.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yoona.quick_start.common.enums.CommonEnums;
import lombok.*;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/15
 * @Time: 3:30 下午
 * @Msg: 系统响应类
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemResponse {

    private int code;
    private Object data;
    private String msg;

    public SystemResponse(CommonEnums result) {
        this.code = result.getCode();
        this.msg = result.getMsg();
    }

    public SystemResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public SystemResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static SystemResponse response(CommonEnums error) {

        return SystemResponse.response(error, null);
    }


    public static SystemResponse response(CommonEnums error, Object data) {

        if (error == null) {
            error = CommonEnums.UN_KNOW_ERROR;
        }
        if (error.equals(CommonEnums.NORMAL)) {
            return SystemResponse.response(error.getCode(), error.getMsg(), data);
        }
        return SystemResponse.response(error.getCode(), error.getMsg(), data);
    }

    public static SystemResponse response(int code, String msg, Object data) {

        return new SystemResponse(code, msg, data);
    }

}