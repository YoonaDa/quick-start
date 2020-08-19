package com.yoona.quick_start.common.util;

import java.util.UUID;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/21
 * @Time: 2:35 下午
 * @Msg: UUID工具类
 */
public class UUIDUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
