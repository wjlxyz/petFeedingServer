package com.petfeeding.server.aspect.token;

import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.request.LoginApiRequest;
import com.petfeeding.server.service.biz.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
@Order(0)
public class TokenValidatorAspect {

    @Autowired
    private TokenService tokenService;

    @Before(value = "@annotation(com.petfeeding.server.aspect.token.TokenValidatorAop)")
    public void validateToken(JoinPoint point) {
        log.info("validate token");
        LoginApiRequest request = (LoginApiRequest) point.getArgs()[0];
        tokenService.validateToken(request);
    }
}
