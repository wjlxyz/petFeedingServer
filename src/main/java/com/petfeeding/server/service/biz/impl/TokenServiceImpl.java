package com.petfeeding.server.service.biz.impl;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.request.LoginApiRequest;
import com.petfeeding.server.service.biz.TokenService;
import com.petfeeding.server.service.constant.CommonConstants;
import com.petfeeding.server.service.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author jinlong
 * @since 2020-01-06 15:20
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * token pattern in redis:
     * key: tk:{userId}
     * value: {token}@{loginAt}
     * expire time: 15days
     *
     * @param request request with token and userId
     */
    @Override
    public void validateToken(LoginApiRequest request) {
        if (request.getUserId() == null || request.getToken() == null) {
            throw new ApiException(ErrorCode.COMMON_ILLEGAL_ARGS_ERROR);
        }
        // token校验成功则将Token过期时间更新为15天
        if (!Objects.equals(redisTemplate.opsForValue().get(CommonConstants.TOKEN_PREFIX + request.getUserId().toString()), request.getToken())) {
            throw new ApiException(ErrorCode.COMMON_TOKEN_EXPIRED_ERROR);
        } else {
            redisTemplate.opsForValue().set(CommonConstants.TOKEN_PREFIX + request.getUserId(),
                    UUID.randomUUID().toString(), CommonConstants.TOKEN_EXPIRE_SECONDS, TimeUnit.SECONDS);
        }
    }
}
