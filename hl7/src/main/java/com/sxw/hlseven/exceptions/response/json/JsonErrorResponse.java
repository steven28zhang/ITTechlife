/**
 * 
 */
package com.sxw.hlseven.exceptions.response.json;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class JsonErrorResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8051667608618535583L;

    @JsonSerialize(include = Inclusion.NON_NULL)
    public String statusCode;

    @JsonSerialize(include = Inclusion.NON_NULL)
    public String apiStatusCode;

    @JsonSerialize(include = Inclusion.NON_NULL)
    public String message;

    /**
     * @return the statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     *            the statusCode to set
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the apiStatusCode
     */
    public String getApiStatusCode() {
        return apiStatusCode;
    }

    /**
     * @param apiStatusCode
     *            the apiStatusCode to set
     */
    public void setApiStatusCode(String apiStatusCode) {
        this.apiStatusCode = apiStatusCode;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
