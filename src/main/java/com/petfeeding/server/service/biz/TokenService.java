package com.petfeeding.server.service.biz;

import com.petfeeding.server.dto.request.LoginApiRequest;

/**
 * @author jinlong
 * @since 2020-01-06 15:03
 */
public interface TokenService {

    void validateToken(LoginApiRequest request);
}
