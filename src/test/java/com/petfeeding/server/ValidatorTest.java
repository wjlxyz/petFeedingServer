package com.petfeeding.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.petfeeding.server.aspect.args.ArgsValidator;
import com.petfeeding.server.dto.request.concrete.user.LoginRequest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

/**
 * @author jinlong
 * @since 2020-01-20 16:53
 */
public class ValidatorTest {

    @Test
    public void validateArgs() {
        LoginRequest request = getLoginRequst();
        request.setMethod(null);
        ArgsValidator.validate(request);
    }

    private LoginRequest getLoginRequst() {
        String loginRequest = "{\"requestId\":1234567890,\"method\": \"login\",\"userId\": \"1048764\"}";
        Type typeToken = new TypeToken<LoginRequest>() {
        }.getType();
        return new Gson().fromJson(loginRequest, typeToken);
    }
}
