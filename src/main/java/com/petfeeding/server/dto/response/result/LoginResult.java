package com.petfeeding.server.dto.response.result;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jinlong
 * @since 2020-01-03 10:20
 */
@Data
public class LoginResult {

    private String token;
    private LocalDateTime expireAt;
}
