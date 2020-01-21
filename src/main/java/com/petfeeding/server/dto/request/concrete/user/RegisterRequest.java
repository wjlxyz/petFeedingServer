package com.petfeeding.server.dto.request.concrete.user;

import com.petfeeding.server.dto.request.UnLoginApiRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author jinlong
 * @since 2020-01-03 10:07
 */
@Data
public class RegisterRequest extends UnLoginApiRequest {

    @NotNull(message = "phoneNumber should not be null")
    private Integer phoneNumber;

    @NotNull(message = "password should not be null")
    private String password;

    @NotNull(message = "role should not be null")
    private Boolean role;
}
