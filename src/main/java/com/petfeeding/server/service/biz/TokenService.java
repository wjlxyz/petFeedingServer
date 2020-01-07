package com.petfeeding.server.service.biz;

import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.token.TokenResult;

/**
 * @author jinlong
 * @since 2020-01-06 15:03
 */
public interface TokenService {

    ApiResponse<TokenResult> validateToken(ApiRequest request);
}
