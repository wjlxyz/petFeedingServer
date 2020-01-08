package com.petfeeding.server.service.biz.impl;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.service.biz.TokenService;
import com.petfeeding.server.service.constant.CommonConstants;
import com.petfeeding.server.service.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
     * key: tk:{accountId}
     * value: {token}@{loginAt}
     * expire time: 30days
     *
     * @param request request with token and accountId
     */
    @Override
    public void validateToken(ApiRequest request) {
        if (request.getAccountId() == null || request.getToken() == null) {
            throw new ApiException(ErrorCode.COMMON_ILLEGAL_ARGS_ERROR);
        }
        if (!Objects.equals(redisTemplate.opsForValue().get(CommonConstants.TOKEN_PREFIX + request.getAccountId().toString()), request.getToken())) {
            throw new ApiException(ErrorCode.COMMON_TOKEN_EXPIRED_ERROR);
        }
    }
}
