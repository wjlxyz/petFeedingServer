package com.petfeeding.server.aspect.token;

import java.lang.annotation.*;

/**
 * @author jinlong
 * @since 2020-01-06 15:08
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenValidatorAop {
}
