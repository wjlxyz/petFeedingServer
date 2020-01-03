package com.petfeeding.server.service.impl;

import com.petfeeding.server.dto.request.concrete.user.LoginRequest;
import com.petfeeding.server.dto.request.concrete.user.RegisterRequest;
import com.petfeeding.server.dto.request.concrete.UpdateUserInfoRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.user.LoginResult;
import com.petfeeding.server.dto.response.result.user.RegisterResult;
import com.petfeeding.server.dto.response.result.user.UpdateUserInfoResult;
import com.petfeeding.server.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public ApiResponse<RegisterResult> register(RegisterRequest request) {
        return ApiResponse.successRespFromReq(request);
    }

    @Override
    public ApiResponse<LoginResult> login(LoginRequest request) {
        return ApiResponse.successRespFromReq(request);
    }

    @Override
    public ApiResponse<UpdateUserInfoResult> updateUserInfo(UpdateUserInfoRequest request) {
        return null;
    }
}
