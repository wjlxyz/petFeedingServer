package com.petfeeding.server.aspect.args;

import com.petfeeding.server.dto.errorcode.ErrorCode;
import com.petfeeding.server.dto.request.ApiRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.service.exception.ApiException;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author jinlong
 * @since 2020-01-20 16:42
 */
public class ArgsValidator {

    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure().failFast(true)
            .buildValidatorFactory()
            .getValidator();

    public static <T> void validate(T target) {
        Set<ConstraintViolation<T>> violations = validator.validate(target);
        checkResult(violations);
    }

    private static <T> void checkResult(Set<ConstraintViolation<T>> violations) {
        if (!violations.isEmpty()) {
            String msg = violations.iterator().next().getMessage();
            throw new ApiException(ErrorCode.COMMON_ILLEGAL_ARGS_ERROR, msg);
        }
    }
}
