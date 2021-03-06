package com.petfeeding.server.service.biz.impl;

import com.petfeeding.server.dal.mapper.UserMapper;
import com.petfeeding.server.dal.model.User;
import com.petfeeding.server.dal.model.UserExample;
import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.concrete.user.*;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.user.*;
import com.petfeeding.server.service.biz.UserService;
import com.petfeeding.server.service.constant.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public ApiResponse<RegisterResult> register(RegisterRequest request) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneNumberEqualTo(request.getPhoneNumber());
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            return ApiResponse.fromReq(request, ErrorCode.USER_HAS_REGISTERED_ERROR);
        }
        User user = new User();
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        user.setUserRole(request.getRole());

        return ApiResponse.successRespFromReq(request);
    }

    @Override
    public ApiResponse<LoginResult> login(LoginRequest request) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneNumberEqualTo(request.getPhoneNumber());
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() <= 0) {
            return ApiResponse.fromReq(request, ErrorCode.USER_NOT_EXISTED_ERROR);
        }
        User user = users.get(0);
        if (!user.getPassword().equals(request.getPassword())) {
            return ApiResponse.fromReq(request, ErrorCode.USER_PHONE_NUMBER_OR_PASSWORD_ERROR);
        }

        redisTemplate.opsForValue().set(CommonConstants.TOKEN_PREFIX + user.getUserId(),
                UUID.randomUUID().toString() + "@" + System.currentTimeMillis(), CommonConstants.TOKEN_EXPIRE_SECONDS, TimeUnit.SECONDS);
        return ApiResponse.successRespFromReq(request);
    }

    @Override
    public ApiResponse<UpdateUserInfoResult> updateUserInfo(UpdateUserInfoRequest request) {
        return null;
    }

    @Override
    public ApiResponse<GetUserInfoResult> getUserInfo(GetUserInfoRequest request) {
        User user = userMapper.selectByPrimaryKey(request.getUserId());
        GetUserInfoResult result = new GetUserInfoResult();
        result.setAccountId(request.getUserId());
        return ApiResponse.successRespFromReqWithResult(request, result);
    }

    @Override
    public ApiResponse<ForgetPwdResult> forgetPwd(ForgetPwdRequest request) {
        return null;
    }
}
