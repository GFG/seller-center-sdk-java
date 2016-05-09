package com.sellercenter.api.core.request;

import java.util.HashMap;
import java.util.Map;

public class Get extends Request {

    /**
     *  {@inheritDoc}
     */
    public Get(
            Map<String, Object> body,
            Map<String, String> params,
            SignatureProvider signatureProvider,
            TimestampFormatter time
    ) {
        super(body, params, signatureProvider, time);
    }

    protected String getAction() {
        return null;
    }

    /**
     *  {@inheritDoc}
     */
    public Get(
            Map<String, String> params,
            String apiKey
    ) {
        super(new HashMap<String, Object>(), params, apiKey);
    }

    /**
     *
     * @param userId The ID of the user making the call.
     * @param secretKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     */
    public Get(String userId, String secretKey, String version) {
        super(new HashMap<String, Object>(), userId, secretKey, version);
    }

    /**
     * {@inheritDoc}
     */
    public String getMethod() {
        return com.sellercenter.api.core.Request.GET;
    }
}
