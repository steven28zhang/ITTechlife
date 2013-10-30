/**
 * 
 */
package com.sxw.hlseven.validation.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sxw.hlseven.validation.validators.StringNotNullEmpty;
import com.sxw.itl.utils.string.StringUtils;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class ValidateStringNotNullEmpty implements ConstraintValidator<StringNotNullEmpty, String> {

    private String errorCode;

    @Override
    public void initialize(StringNotNullEmpty arg0) {
        errorCode = arg0.errorCode();
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        if (!StringUtils.isNotEmptyAndNull(arg0)) {
            arg1.disableDefaultConstraintViolation();
            arg1.buildConstraintViolationWithTemplate(errorCode).addConstraintViolation();
            return false;
        }
        return true;
    }

}
