package com.sellercenter.api.core.request;

import java.util.Map;

public class Post extends Request {

    /**
     * {@inheritDoc}
     */
    public Post(
            Map<String, Object> body,
            Map<String, String> params,
            SignatureProvider signatureProvider,
            TimestampFormatter time
    ) {
        super(body, params, signatureProvider, time);
    }

    /**
     * @param body
     * @param userId The ID of the user making the call.
     * @param secretKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     */
    public Post(Map<String, Object> body, String userId, String secretKey, String version) {
        super(body, userId, secretKey, version);
    }

    /**
     * {@inheritDoc}
     */
    public String getMethod() {
        return com.sellercenter.api.core.Request.POST;
    }
}
