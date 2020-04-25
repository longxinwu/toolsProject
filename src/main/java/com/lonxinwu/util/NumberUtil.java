package com.lonxinwu.util;

import java.text.DecimalFormat;

public class NumberUtil {


    public static void main(String[] args){
        double num = 1234.5678;
        //取全部整数位加三位小数
        System.out.println(new DecimalFormat("#.000").format(num));
        //取整数位
        System.out.println(new DecimalFormat("0").format(num));
        //取两位整数，取两位小数
        System.out.println(new DecimalFormat("00.00").format(num));
        //取6位整数，整数不足前面补0
        System.out.println(new DecimalFormat("000000.00").format(num));
        //取百分比
        System.out.println(new DecimalFormat("0.00%").format(num));
    }
}
