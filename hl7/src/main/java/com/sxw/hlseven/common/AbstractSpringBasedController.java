package com.sxw.hlseven.common;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.sxw.hlseven.exceptions.response.json.JsonErrorResponse;
import com.sxw.itl.common.ITLConstants.ErrorCodes;
import com.sxw.itl.common.ITLConstants.ErrorMessage;

/**
 * 
 * @author Stephen.Zhang@covisint.com
 * 
 */
public abstract class AbstractSpringBasedController {

    public JsonErrorResponse createJsonErrorResponseBasedException(final Exception e) {
        JsonErrorResponse jsonErrorResponse = new JsonErrorResponse();
        jsonErrorResponse.setStatusCode(ErrorCodes.internalServerError_400);
        if (e instanceof NumberFormatException) {
            jsonErrorResponse.setApiStatusCode(ErrorCodes.INVALID_SOURCE_DATATYPE_4120);
        }else if(e instanceof RuntimeException){
            jsonErrorResponse.setApiStatusCode(ErrorCodes.INVALID_SOURCE_DATATYPE_4120);
        }

        jsonErrorResponse.setMessage(ErrorMessage.INTERNAL_SERVER_ERROR);
        return jsonErrorResponse;
    }

    /**
     * 
     * @param errors
     * @return
     */
    public String getErrorCode(final BindingResult errors) {
        if (errors.hasErrors()) {
            List<ObjectError> objectErrors = errors.getAllErrors();

            if (objectErrors != null && objectErrors.size() > 0) {
                ObjectError objectError = objectErrors.get(0);
                if (objectError != null) {
                    return objectError.getCode();

                }
            }
        }
        return null;
    }
}
