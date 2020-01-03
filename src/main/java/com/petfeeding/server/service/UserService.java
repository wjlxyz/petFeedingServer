package com.petfeeding.server.service;

import com.petfeeding.server.dto.request.concrete.user.LoginRequest;
import com.petfeeding.server.dto.request.concrete.user.RegisterRequest;
import com.petfeeding.server.dto.request.concrete.UpdateUserInfoRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.user.LoginResult;
import com.petfeeding.server.dto.response.result.user.RegisterResult;
import com.petfeeding.server.dto.response.result.user.UpdateUserInfoResult;

/**
 * @author jinlong
 * @since 2020-01-03 10:52
 */
public interface UserService {

    ApiResponse<RegisterResult> register(RegisterRequest request);

    ApiResponse<LoginResult> login(LoginRequest request);

    ApiResponse<UpdateUserInfoResult> updateUserInfo(UpdateUserInfoRequest request);
}
