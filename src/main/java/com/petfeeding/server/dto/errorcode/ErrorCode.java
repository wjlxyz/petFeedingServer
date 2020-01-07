package com.petfeeding.server.dto.errorcode;

/**
 * errorCode pattern: -{a:versionNo}{bb:typeNo}{cc:code}
 */
public enum  ErrorCode {

    SUCCESS(0, "Success"),

    INTERNAL_ERROR(-10101, "服务器内部错误"),

    COMMON_ILLEGAL_ARGS_ERROR(-10201, "参数错误"),

    COMMON_TOKEN_EXPIRED_ERROR(-10202, "token过期")

    ;


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

    public boolean isSuccess() {
        return this.equals(SUCCESS);
    }
}
