package com.petfeeding.server.service.exception;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.VoidResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinlong
 * @since 2020-01-07 17:04
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResponse<VoidResult> defaultExceptionHandler(HttpServletRequest request, Exception e) {
        return ApiResponse.globalInternalErrorResp();
    }
}
