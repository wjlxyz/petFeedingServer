package com.petfeeding.server.dto.request.concrete.user;

import com.petfeeding.server.dto.request.ApiRequest;
import lombok.Data;

/**
 * @author jinlong
 * @since 2020-01-03 10:07
 */
@Data
public class RegisterRequest extends ApiRequest {
    private Long phoneNumber;
    private String password;
}
