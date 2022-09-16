package com.ane.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangleilei
 * @description
 * @create 2021/6/16
 */
public class DateUtil {

    public static Long getAllTimestamp(String time) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(time);
        return date.getTime();
    }

    public static String getDateYearString(Long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateStr = format.format(new Date(timeStamp));
        return dateStr;
    }
}
