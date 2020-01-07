package com.petfeeding.server.service.biz.impl;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.token.TokenResult;
import com.petfeeding.server.service.biz.TokenService;
import org.springframework.stereotype.Service;

/**
 * @author jinlong
 * @since 2020-01-06 15:20
 */
@Service
public class TokenServiceImpl implements TokenService {

    /**
     * token pattern in redis:
     * key: tk:{accountId}
     * value: {token}@{loginAt}
     * expire time: 30days
     *
     * @param request request with token and accountId
     * @return if the token of request is valid
     */
    @Override
    public ApiResponse<TokenResult> validateToken(ApiRequest request) {
        if (request.getAccountId() == null || request.getToken() == null) {
            return ApiResponse.fromReq(request, ErrorCode.COMMON_ILLEGAL_ARGS_ERROR);
        }

        return ApiResponse.fromReq(request, ErrorCode.COMMON_TOKEN_EXPIRED_ERROR);
    }
}
