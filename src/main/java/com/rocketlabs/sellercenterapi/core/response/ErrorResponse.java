package com.rocketlabs.sellercenterapi.core.response;

import javax.json.JsonObject;

/**
 * See https://sellercenter.readme.io/docs/errors for more information
 * about different errors.
 */
public class ErrorResponse extends AbstractResponse {

    private final String errorType;
    private final int errorCode;
    private final String errorMessage;

    /**
     * Constructor
     *
     * @param requestAction action that was requested
     * @param errorType     type of the error
     * @param errorCode     integer referencing the error
     * @param errorMessage  more information about error
     * @param body          body of the response
     */
    ErrorResponse(
            String requestAction,
            String errorType,
            String errorCode,
            String errorMessage,
            JsonObject body) {
        super(requestAction, body);

        this.errorType = errorType;
        this.errorCode = Integer.parseInt(errorCode);
        this.errorMessage = errorMessage;
    }

    /**
     * Simple getter for the error message.
     *
     * @return Error messages
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Simple getter for the error code.
     *
     * @return Error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Simple getter for the error type.
     *
     * @return Error type
     */
    public String getErrorType() {
        return errorType;
    }
}
