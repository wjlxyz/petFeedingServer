package com.petfeeding.server.dto.request.concrete.user;

import com.petfeeding.server.dto.request.UnLoginApiRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author jinlong
 * @since 2020-01-03 10:10
 */
@Data
public class LoginRequest extends UnLoginApiRequest {

    @NotBlank(message = "phoneNumber should not be blank")
    private Integer phoneNumber;

    @NotBlank(message = "password should not be blank")
    private String password;
}
