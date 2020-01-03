package com.petfeeding.server.controller;

import com.petfeeding.server.dto.response.result.LoginResult;
import com.petfeeding.server.dto.response.result.RegisterResult;
import com.petfeeding.server.dto.request.concrete.LoginRequest;
import com.petfeeding.server.dto.request.concrete.RegisterRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/server/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ApiResponse<RegisterResult> register(RegisterRequest request) {
        return userService.register(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ApiResponse<LoginResult> register(LoginRequest request) {
        return userService.login(request);
    }
}
