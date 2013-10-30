package com.sxw.hlseven.validation.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sxw.hlseven.validation.validators.impl.ValidateStringNotNullEmpty;

/**
 * validate a string and return false if it's null or empty<br>
 * 
 * @author Stephen.Zhang@covisint.com
 * 
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateStringNotNullEmpty.class)
@Documented
public @interface StringNotNullEmpty {

    String message() default "";

    String errorCode();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
