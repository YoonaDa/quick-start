package com.yoona.quick_start.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/21
 * @Time: 10:34 上午
 * @Msg: 时间工具类
 */
public class TimeUtil {
    /**
     * 获得当前的时间 格式为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    /**
     * 获得当前的时间 格式为：yyyy年yy月yy日
     * @return
     */
    public static String getTimeCN() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }


}
