package com.yxk.simpleLibrary.common;

/**
 * @Description: 结果Json字符串的状态码
 * @Date: 2022/5/31
 **/
public enum ResultCode {

    SUCCESS(200, "成功"),

    BAD_REQUEST(400, "参数或者语法不对"),
    UNAUTHORIZED(401, "认证失败"),
    LOGIN_ERROR(402, "登录失败，用户名或密码无效"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "请求的资源不存在"),
    OPERATE_ERROR(405, "操作失败，请求操作的资源不存在"),
    TIME_OUT(408, "请求超时"),

    NO_IDS(308, "请选择勾选的数据"),

    SERVER_ERROR(500, "服务器内部错误"),

    GENERATOR_FAILURE(501,"生成失败"),

    USERNAME_OR_EMAIL_EXIST(20001,"用户名或邮箱已存在")
    ;


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
