package com.sellercenter.api.core.response;

import com.sellercenter.api.core.Response;

import javax.json.JsonObject;

abstract class AbstractResponse implements Response {

    /**
     * Name of the action that provoked this response
     */
    private final String requestAction;

    /**
     * Body of the response
     * Contains mainly data in case of success
     */
    private final JsonObject body;

    /**
     * Constructor
     *
     * @param requestAction the Action that triggered this response
     * @param body          the content of the response (only 'body' section included)
     */
    AbstractResponse(String requestAction, JsonObject body) {
        this.requestAction = requestAction;
        this.body = body;
    }

    /**
     * Getter for requestAction
     * @return action that provoked this response
     */
    public String getRequestAction() {
        return requestAction;
    }

    /**
     * Getter for body
     * @return body of the response
     */
    public JsonObject getBody() {
        return body;
    }
}
