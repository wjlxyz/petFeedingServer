package com.petfeeding.server.service;

import com.petfeeding.server.dto.request.Request;
import com.petfeeding.server.dto.response.object.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public RegisterResponse register(Request request) {
        System.out.println(request);
        RegisterResponse registerResponse = new RegisterResponse();
        System.out.println(registerResponse);
        return registerResponse;
    }
}
