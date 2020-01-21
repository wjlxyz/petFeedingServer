package com.petfeeding.server.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author jinlong
 * @since 2020-01-21 16:22
 */
@Data
public class LoginApiRequest extends ApiRequest {

    @NotNull(message = "userId should not be null")
    private Integer userId;

    @NotNull(message = "token should not be null")
    private String token;
}
