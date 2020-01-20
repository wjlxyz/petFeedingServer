package com.petfeeding.server.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public abstract class ApiRequest {

    @NotNull
    private Long requestId;

    @NotNull
    private String method;
}
