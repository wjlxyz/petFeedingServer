package com.petfeeding.server.service.biz.impl;

import com.petfeeding.server.dal.mapper.UserMapper;
import com.petfeeding.server.dal.model.User;
import com.petfeeding.server.dto.request.concrete.user.UpdateUserInfoRequest;
import com.petfeeding.server.dto.request.concrete.user.GetUserInfoRequest;
import com.petfeeding.server.dto.request.concrete.user.LoginRequest;
import com.petfeeding.server.dto.request.concrete.user.RegisterRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.user.GetUserInfoResult;
import com.petfeeding.server.dto.response.result.user.LoginResult;
import com.petfeeding.server.dto.response.result.user.RegisterResult;
import com.petfeeding.server.dto.response.result.user.UpdateUserInfoResult;
import com.petfeeding.server.service.biz.UserService;
import com.petfeeding.server.service.constant.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ApiResponse<RegisterResult> register(RegisterRequest request) {
        return ApiResponse.successRespFromReq(request);
    }

    @Override
    public ApiResponse<LoginResult> login(LoginRequest request) {
        redisTemplate.opsForValue().set(CommonConstants.TOKEN_PREFIX + request.getAccountId(),
                UUID.randomUUID().toString(), CommonConstants.TOKEN_EXPIRE_SECONDS, TimeUnit.SECONDS);
        return ApiResponse.successRespFromReq(request);
    }

    @Override
    public ApiResponse<UpdateUserInfoResult> updateUserInfo(UpdateUserInfoRequest request) {
        return null;
    }

    @Override
    public ApiResponse<GetUserInfoResult> getUserInfo(GetUserInfoRequest request) {
        User user = userMapper.selectByPrimaryKey(request.getAccountId().toString());
        GetUserInfoResult result = new GetUserInfoResult();
        result.setAccountId(request.getAccountId());
        return ApiResponse.successRespFromReqWithResult(request, result);
    }
}
