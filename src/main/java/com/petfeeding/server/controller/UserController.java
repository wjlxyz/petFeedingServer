package com.petfeeding.server.controller;

import com.petfeeding.server.aspect.token.TokenValidatorAop;
import com.petfeeding.server.dto.response.result.user.LoginResult;
import com.petfeeding.server.dto.response.result.user.RegisterResult;
import com.petfeeding.server.dto.request.concrete.user.LoginRequest;
import com.petfeeding.server.dto.request.concrete.user.RegisterRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.aspect.log.LogAop;
import com.petfeeding.server.service.biz.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/server/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@LogAop(description = "user controller log aspect")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ApiResponse<RegisterResult> register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    @TokenValidatorAop
    public ApiResponse<LoginResult> login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
