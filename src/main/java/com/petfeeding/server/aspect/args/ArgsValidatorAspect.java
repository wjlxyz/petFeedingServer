package com.petfeeding.server.aspect.args;

import com.petfeeding.server.dto.request.ApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jinlong
 * @since 2020-01-20 16:37
 */
@Slf4j
@Aspect
@Component
@Order(-1)
public class ArgsValidatorAspect {

    @Pointcut("execution(* com.petfeeding.server.controller.*.*(..)) && args(request)")
    public void argsValidatorPointCut(ApiRequest request) {
    }

    @Before(value = "argsValidatorPointCut(request)")
    public void validateArgs(JoinPoint joinPoint, ApiRequest request) {
        ArgsValidator.validate(request);
    }
}
