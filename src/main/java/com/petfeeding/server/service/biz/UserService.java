package com.petfeeding.server.service.biz;

import com.petfeeding.server.dto.request.concrete.user.*;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.user.*;

/**
 * @author jinlong
 * @since 2020-01-03 10:52
 */
public interface UserService {

    ApiResponse<RegisterResult> register(RegisterRequest request);

    ApiResponse<LoginResult> login(LoginRequest request);

    ApiResponse<UpdateUserInfoResult> updateUserInfo(UpdateUserInfoRequest request);

    ApiResponse<GetUserInfoResult> getUserInfo(GetUserInfoRequest request);

    ApiResponse<ForgetPwdResult> forgetPwd(ForgetPwdRequest request);
}
