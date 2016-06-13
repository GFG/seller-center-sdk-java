package com.sellercenter.api.core.response;

import javax.json.JsonObject;

public class SuccessResponse extends AbstractResponse {

    private final String responseType;
    private final String timestamp;

    /**
     * Constructor
     *
     * @param requestAction Name of the function that is to be called
     * @param responseType  the type of data in the response
     * @param timestamp     timestamp of the response as string
     * @param body          Map representing the 'body' section of the response
     */
    SuccessResponse(String requestAction, String responseType, String timestamp, JsonObject body) {
        super(requestAction, body);

        this.responseType = responseType;
        this.timestamp = timestamp;
    }

    /**
     * Timestamp of the response
     *
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Type of the data in the body
     *
     * @return type
     */
    public String getResponseType() {
        return responseType;
    }
}
