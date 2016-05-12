package com.sellercenter.api.core.response;

import com.sellercenter.api.core.Response;

import java.util.Map;

public class ConcreteResponse implements Response {

    private final SuccessResponse response;

    /**
     * Constructor
     *
     * @param successResponse the successful response returned by the client
     */
    public ConcreteResponse(SuccessResponse successResponse) {
        this.response = successResponse;
    }

    /**
     * @inheritDoc
     */
    public boolean isError() {
        return false;
    }

    /**
     * @inheritDoc
     */
    public String getRequestAction() {
        return response.getRequestAction();
    }

    /**
     * @inheritDoc
     */
    public Map<String, Object> getBody() {
        return response.getBody();
    }

    /**
     * Timestamp of the response
     * @return timestamp as a string
     */
    public String getResponseType () {
        return response.getResponseType();
    }

    /**
     * Type of the data in the body
     * @return type as string
     */
    public String getTimestamp () {
        return response.getTimestamp();
    }
}
