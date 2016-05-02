package com.sellercenter.api.core.request;

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

    /**
     * {@inheritDoc}
     */
    public Get(
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
        return com.sellercenter.api.core.Request.GET;
    }
}
