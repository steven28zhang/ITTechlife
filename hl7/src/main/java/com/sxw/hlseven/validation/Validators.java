/**
 * 
 */
package com.sxw.hlseven.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.sxw.hlseven.validation.groups.ValidationJsonSequence;
import com.sxw.itl.common.ITLConstants.ErrorCodes;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
@Component
public class Validators {

    public void validateJson(Errors errors, Object object) {
        validateJSONObject(object, errors);
    }

    /**
     * validate the json entity<br>
     * 
     * @param object
     * @param errors
     * @return
     */
    public <T> boolean validateJSONObject(T object, Errors errors) {

        if (object == null || errors == null) {
            throw new IllegalArgumentException(ErrorCodes.argumentException_5001);
        }
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, ValidationJsonSequence.class);

        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            errors.reject(constraintViolation.getMessage());
            return false;
        }
        return true;
    }
}
