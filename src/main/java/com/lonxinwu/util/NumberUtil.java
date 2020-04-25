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

        /**
         * 扩展，如果是其他的数字会是下面的效果
         */
        double pi=12.34;
        //整数
        System.out.println(new DecimalFormat("6").format(pi));//612
        System.out.println(new DecimalFormat("60").format(pi));//612
        System.out.println(new DecimalFormat("06").format(pi));//126
        System.out.println(new DecimalFormat("00600").format(pi));//00126
        System.out.println(new DecimalFormat("#####60000").format(pi));//00126
        //小数
        System.out.println(new DecimalFormat(".6").format(pi));//12.6
        System.out.println(new DecimalFormat(".06").format(pi));//12.36
        System.out.println(new DecimalFormat(".60").format(pi));//12.36
        System.out.println(new DecimalFormat(".0600").format(pi));//12.3406
        System.out.println(new DecimalFormat(".6000").format(pi));//12.3406
        System.out.println(new DecimalFormat(".600000##").format(pi));//12.340006
    }
}
