package com.petfeeding.server.dto.request;

import lombok.Data;

@Data
public abstract class ApiRequest {

    private Long requestId;
    private String method;
    private Integer accountId;
    private String token;
}
