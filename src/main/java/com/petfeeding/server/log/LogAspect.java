package com.petfeeding.server.log;

import com.google.gson.Gson;
import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author jinlong
 * @since 2020-01-03 15:14
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    private static Gson gson = new Gson();

    @Pointcut("@within(com.petfeeding.server.log.LogAop)")
    public void handleRequestLogPointCut() {
    }

    @Around(value = "handleRequestLogPointCut()")
    public ApiResponse log(ProceedingJoinPoint point) throws Throwable {
        ApiRequest request = (ApiRequest) point.getArgs()[0];
        log.info("server.recv: " + gson.toJson(request));
        ApiResponse response = (ApiResponse) point.proceed();
        log.info("server.send: " + gson.toJson(response));
        return response;
    }
}
