package com.petfeeding.server.dto.request;

import lombok.Data;

@Data
public class Request {

    private Long requestId;
    private Integer accountId;
    private String token;
}
