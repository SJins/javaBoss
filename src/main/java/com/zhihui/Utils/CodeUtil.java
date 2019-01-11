package com.zhihui.Utils;

public class CodeUtil {

    public static String random(){

        return String.valueOf(Math.round(Math.floor(((Math.random()*9)+1)*100000)));
    }
}
