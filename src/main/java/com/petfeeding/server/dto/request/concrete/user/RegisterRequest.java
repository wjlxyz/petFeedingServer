package com.petfeeding.server.dto.request.concrete.user;

import com.petfeeding.server.dto.request.ApiRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author jinlong
 * @since 2020-01-03 10:07
 */
@Data
public class RegisterRequest extends ApiRequest {

    @NotBlank(message = "phoneNumber should not be blank")
    private Long phoneNumber;

    @NotBlank(message = "password should not be blank")
    private String password;
}
