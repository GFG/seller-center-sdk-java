package com.sellercenter.api.core.response;

import com.sellercenter.api.core.Response;

import java.util.Map;

abstract class AbstractResponse implements Response {

	private String requestAction;
    private Map<String, Object> body;

    /**
     * Constructor
     * @param requestAction the Action that triggered this response
     * @param body the content of the response (only 'body' section included)
     */
    AbstractResponse(String requestAction, Map<String, Object> body) {
        this.requestAction = requestAction;
        this.body = body;
    }

    public String getRequestAction() {
        return requestAction;
    }

    public Map<String, Object> getBody() {
        return body;
    }
}
