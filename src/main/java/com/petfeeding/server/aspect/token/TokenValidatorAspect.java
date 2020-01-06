package com.petfeeding.server.aspect.token;

import com.google.gson.Gson;
import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.token.TokenResult;
import com.petfeeding.server.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jinlong
 * @since 2020-01-06 15:09
 */
@Slf4j
@Aspect
@Component
@Order(-1)
public class TokenValidatorAspect {

    @Autowired
    private TokenService tokenService;

    private static Gson gson = new Gson();

    @Pointcut("@within(com.petfeeding.server.aspect.token.TokenValidatorAop)")
    public void handleTokenValidatorPointCut() {
    }

    @Around(value = "handleTokenValidatorPointCut()")
    public void validateToken(ProceedingJoinPoint point) throws Throwable {
        log.info("validate token");
        ApiRequest request = (ApiRequest) point.getArgs()[0];
        ApiResponse<TokenResult> response = tokenService.validateToken(request);
        if (response.getErrorCode().isSuccess()) {
            point.proceed();
        } else {
            throw new RuntimeException(ErrorCode.COMMON_TOKEN_EXPIRED_ERROR.getMsg());
        }
    }
}
