package com.petfeeding.server.service;

import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.request.concrete.LoginRequest;
import com.petfeeding.server.dto.request.concrete.RegisterRequest;
import com.petfeeding.server.dto.request.concrete.UpdateUserInfoRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.LoginResult;
import com.petfeeding.server.dto.response.result.RegisterResult;
import com.petfeeding.server.dto.response.result.UpdateUserInfoResult;

/**
 * @author jinlong
 * @since 2020-01-03 10:52
 */
public interface UserService {

    ApiResponse<RegisterResult> register(RegisterRequest request);

    ApiResponse<LoginResult> login(LoginRequest request);

    ApiResponse<UpdateUserInfoResult> updateUserInfo(UpdateUserInfoRequest request);
}
