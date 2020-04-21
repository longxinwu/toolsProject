package com.lonxinwu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static void main(String[] args) throws ParseException {
        Date startDt = new Date();
        String dateStr = "2020/04/04";
        System.out.println(DateUtil.dateToStr(startDt, "yyyy-MM-dd"));
        Date endDt = DateUtil.strToDate(dateStr, "yyyy/MM/dd");
        System.out.println(endDt.toString());
        System.out.println(startDt.before(endDt));

    }
    public static String dateToStr(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(date);
        return dateStr;
    }
    public static Date strToDate(String str,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(str);
        return date;
    }
}
