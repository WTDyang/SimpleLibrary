package com.yxk.simpleLibrary.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultJson<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public static com.yxk.simpleLibrary.common.ResultJson success(){return success("");}

    public static com.yxk.simpleLibrary.common.ResultJson success(Object obj){return new com.yxk.simpleLibrary.common.ResultJson(com.yxk.simpleLibrary.common.ResultCode.SUCCESS,obj);}

    public static com.yxk.simpleLibrary.common.ResultJson failure(com.yxk.simpleLibrary.common.ResultCode resultCode){return failure(resultCode,"");}

    public static com.yxk.simpleLibrary.common.ResultJson failure(com.yxk.simpleLibrary.common.ResultCode resultCode, Object obj){return new com.yxk.simpleLibrary.common.ResultJson(resultCode,obj);}

    public ResultJson(com.yxk.simpleLibrary.common.ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultJson(com.yxk.simpleLibrary.common.ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public void setResultCode(com.yxk.simpleLibrary.common.ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    @Override
    public String toString() {
        return "ResultJson{" +
                "code=" + code +
                ", msg='" + msg + "'" +
                ", data=" + data +
                '}';
    }
}
