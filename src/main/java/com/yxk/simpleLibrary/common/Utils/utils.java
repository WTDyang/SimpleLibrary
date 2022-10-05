package com.yxk.simpleLibrary.common.Utils;

public class utils {
    //变量判空
    public static boolean isNotBlank(String obj){
        if(obj == null || obj.equals("")){
            return false;
        }else{
            return true;
        }
    }
}
