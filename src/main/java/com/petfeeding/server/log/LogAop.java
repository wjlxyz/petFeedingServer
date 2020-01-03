package com.petfeeding.server.log;

import java.lang.annotation.*;

/**
 * @author jinlong
 * @since 2020-01-03 15:32
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAop {
    String description() default "";
}
