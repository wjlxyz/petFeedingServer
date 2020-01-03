package com.petfeeding.server.dto.response.object;

import com.petfeeding.server.dto.response.Response;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginResponse extends Response<LoginResponse> {

    public String token;
    public LocalDateTime expireAt;
}
