package com.sellercenter.api.core.response;

import java.util.Map;

public class ErrorResponse extends AbstractResponse {

    private String errorType;
    private int errorCode;
    private String errorMessage;

    /**
     * Constructor
     * @param requestAction action that was requested
     * @param errorType type of the error
     * @param errorCode integer referencing the error
     * @param errorMessage more information about error
     */
    public ErrorResponse(
            String requestAction,
            String errorType,
            String errorCode,
            String errorMessage
    ) {
        super(requestAction, null);

        this.errorType = errorType;
        this.errorCode = Integer.parseInt(errorCode);
        this.errorMessage = errorMessage;
    }

    /**
     * {@inheritDoc}
     */
	public boolean isError() {
		return true;
	}

    /**
     * Simple getter for the error message.
     * See https://sellercenter.readme.io/docs/errors for more information
     * about different error messages
     *
     * @return Error messages
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Simple getter for the error code.
     * See https://sellercenter.readme.io/docs/errors for more information
     * about different error codes
     *
     * @return Error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Simple getter for the error type.
     * See https://sellercenter.readme.io/docs/errors for more information
     * about different error types
     *
     * @return Error type
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getBody() {
        return null;
    }
}
