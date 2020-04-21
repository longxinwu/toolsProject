package com.lonxinwu.util;

public class StringUtil {
    public static void main(String[] args){
        String str = "wangbo";
        String str2 = String.format("%-12s", str);
        String str3 = String.format("%12s",str);
        //System.out.println(str+"--"+str3+"----"+str2);
        //String str4 = paddingBlank(str, 12);
        //paddingBlank2(str, 12);
        String formatName = formatStr(str);
        System.out.println("start"+formatStr("1234567")+"end");
        System.out.println("start"+formatStr("123456")+"end");
        System.out.println("start"+formatStr("12345")+"end");
    }
    public static String paddingBlank(String str, int size){
        int num = size/2;
        String strRight = String.format("%-"+num+"s", str);
        System.out.println(strRight+"end");
        String strLeft = String.format("%"+num+"s", strRight);
        System.out.println("start"+strLeft+"end");
        return strLeft;
    }

    public static String paddingBlank2(String str, int size){
        int num = size/2;
        String str1 = "";
        for(int i=0; i<num;i++){
            str1+=" ";
        }
        String strfinal = str1+str+str1;
        System.out.println(strfinal.length());
        System.out.println("--"+strfinal+"--");
        return strfinal;
    }

    public static String formatStr(String name){
        String formatNm = "";
        int left = (25-name.length())/2;
        int right = 25-left-name.length();
        for(int i=0;i<left;i++){
            formatNm+=" ";
        }
        formatNm=formatNm+name;
        for(int j=0;j<right;j++){
            formatNm+=" ";
        }
        return formatNm;
    }
}
