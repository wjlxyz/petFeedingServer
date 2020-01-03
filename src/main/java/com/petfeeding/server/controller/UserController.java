package com.petfeeding.server.controller;

import com.petfeeding.server.dto.request.Request;
import com.petfeeding.server.dto.response.object.RegisterResponse;
import com.petfeeding.server.service.UserService;
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
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public RegisterResponse register(Request request) {
        return userService.register(request);
    }
}
