package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;

import java.util.Date;
import java.util.Map;

public abstract class Request implements com.sellercenter.api.core.Request {

    private final static String defaultFormat = "JSON";
    private Map<String, Object> body;
    private Map<String,String> params;
    private SignatureProvider signatureProvider;
    private TimestampFormatter time;

    /**
     *
     * @param body Map representing the body of the request
     * @param params Map representing the query of the request
     * @param signatureProvider Tool to compute signature
     * @param time Tool to format the date
     */
    public Request(
            Map<String, Object> body,
            Map<String, String> params,
            SignatureProvider signatureProvider,
            TimestampFormatter time
    ) {
        this.body = body;
        this.params = params;
        this.signatureProvider = signatureProvider;
        this.time = time;

        this.params.put("Format", defaultFormat);
        if (null == this.params.get("Timestamp")) {
            updateTimestamp(null);
        }
    }

    /**
     *
     * @param body Map representing the body of the request
     * @param params Map representing the query of the request
     * @param secretKey The API key to sign the request
     */
    public Request(Map<String, Object> body, Map<String, String> params, String secretKey) {
        this(
                body,
                params,
                new HashHmacSignatureProvider(secretKey),
                new TimestampFormatter()
        );
    }

    /**
     * Returns the body of a the request
     * @return Map of the body, as passed to the constructor
     */
    public Map<String, Object> getBody() {
        return body;
    }

    /**
     * Returns the parameters of a request, signature included.
     *
     * @return Map of representing the parameters
     * @throws SdkException
     */
    public Map<String, String> getParams() throws SdkException {
        computeSignature();
        return params;
    }

    /**
     * Update the timestamp of the request
     *
     * @param now The new date, if null given will be now.
     */
    public void updateTimestamp(Date now) {
        String date = time.getTimestamp(now);
        params.put("Timestamp", date);
    }

    /**
     * Recompute the signature of the request and store it with other
     * query parameters
     *
     * @throws SdkException
     */
    private void computeSignature() throws SdkException {
        params.remove("Signature");
        String signature = signatureProvider.sign(params);
        params.put("Signature", signature);
    }
}
