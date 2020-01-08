package com.petfeeding.server.service.exception.handler;

import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.VoidResult;
import com.petfeeding.server.service.exception.ApiException;
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

    @ExceptionHandler(value = ApiException.class)
    public ApiResponse<VoidResult> defaultExceptionHandler(HttpServletRequest request, ApiException e) {
        return ApiResponse.globalInternalErrorResp(e.getErrorCode());
    }
}
