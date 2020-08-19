package com.yoona.quick_start.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/15
 * @Time: 4:02 下午
 * @Msg: 系统通用状态枚举
 */
@Getter
@AllArgsConstructor
public enum CommonEnums {
    /**
     * 公共
     */
    NORMAL(1, "操作成功"),
    UN_KNOW_ERROR(-1, "未知错误"),

    ERROR(-1,"失败!"),
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),

    PARAM_ERROR(1000,"参数错误"),
    PARAM_IS_NULL(1001,"含有空参数,请重新输入"),
    /**
     * 业务
     */
    SELECT_SUCCESS(2001, "查询成功"),
    SELECT_ERROR(2002, "查询失败"),
    INSERT_SUCCESS(2003, "新增成功"),
    INSERT_ERROR(2004, "新增失败"),
    UPDATE_SUCCESS(2005, "更新成功"),
    UPDATE_ERROR(2006, "更新失败"),
    DELETE_SUCCESS(2007, "删除成功"),
    DELETE_ERROR(2008, "删除失败"),
    BATCH_DELETE_SUCCESS(2009, "批量删除成功"),
    BATCH_DELETE_ERROR(2010,"批量删除失败"),

    USERNAME_IS_REGISTERED(2100,"用户名已经被注册");




    ;


    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
