package com.petfeeding.server.dto.response;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import lombok.Data;

@Data
public class Response<T> {

    private ErrorCode errorCode;
    private T result;
}
