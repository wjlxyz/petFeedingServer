package com.petfeeding.server.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public abstract class ApiRequest {

    @NotNull(message = "requestId should not be null")
    private Long requestId;

    @NotNull(message = "method should not be null")
    private String method;

    @NotNull(message = "accountId should not be null")
    private Integer accountId;

    private String token;

}
