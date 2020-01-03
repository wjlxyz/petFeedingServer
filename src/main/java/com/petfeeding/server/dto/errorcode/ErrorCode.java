package com.petfeeding.server.dto.errorcode;

public enum  ErrorCode {

    SUCCESS(0, "Success"),
    INTERNAL_ERROR(-100001, "模块内部错误");


    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
