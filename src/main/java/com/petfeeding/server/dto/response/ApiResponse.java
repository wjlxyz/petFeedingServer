package com.petfeeding.server.dto.response;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.ApiRequest;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class ApiResponse<T> {

    @NotNull(message = "requestId should not be null")
    private Long requestId;

    @NotNull
    private Integer code;
    private String msg;
    private T result;

    @NotNull(message = "errorCode should not be null")
    private transient ErrorCode errorCode;

    private ApiResponse(Long requestId, ErrorCode errorCode) {
        this(requestId, errorCode, null);
    }

    private ApiResponse(Long requestId, ErrorCode errorCode, T result) {
        this.requestId = requestId;
        this.errorCode = errorCode;
        this.result = result;
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static <T> ApiResponse<T> successRespFromReq(ApiRequest request) {
        return fromReq(request, ErrorCode.SUCCESS);
    }

    public static <T> ApiResponse<T> successRespFromReqWithResult(ApiRequest request, T result) {
        return fromReq(request, ErrorCode.SUCCESS, result);
    }

    public static <T> ApiResponse<T> fromReq(ApiRequest request, ErrorCode errorCode) {
        return fromReq(request, errorCode, null);
    }

    public static <T> ApiResponse<T> fromReq(@NotNull ApiRequest request, @NotNull ErrorCode errorCode, @Nullable T result) {
        return new ApiResponse<>(request.getRequestId(), errorCode, result);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "requestId=" + requestId +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(ErrorCode errorCode) {
        this.code = errorCode.getCode();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(ErrorCode errorCode) {
        this.msg = errorCode.getMsg();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
