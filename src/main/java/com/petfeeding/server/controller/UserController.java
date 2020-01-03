package com.petfeeding.server.controller;

import com.petfeeding.server.dto.request.Request;
import com.petfeeding.server.dto.response.object.RegisterResponse;
import com.petfeeding.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/server/api/v1/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;
    public RegisterResponse register(Request request) {
        RegisterResponse registerResponse = new RegisterResponse();
        System.out.println(registerResponse);
        return registerResponse;
    }
}
