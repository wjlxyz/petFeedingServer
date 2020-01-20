package com.petfeeding.server.dto.request.concrete.user;

import com.petfeeding.server.dto.request.ApiRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author jinlong
 * @since 2020-01-03 10:10
 */
@Data
public class LoginRequest extends ApiRequest {
    @NotNull
    private Integer accountId;
}
