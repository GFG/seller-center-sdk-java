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
     * {@inheritDoc}
     */
    public Post(
            Map<String, Object> body,
            Map<String, String> params,
            String secretKey
    ) {
        super(body, params, secretKey);
    }

    /**
     * {@inheritDoc}
     */
    public String getMethod() {
        return com.sellercenter.api.core.Request.POST;
    }
}
