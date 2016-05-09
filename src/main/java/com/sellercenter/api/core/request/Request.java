package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Request implements com.sellercenter.api.core.Request {

    private final static String SDK_FORMAT = "JSON";
    private Map<String, Object> body;
    private Map<String,String> params;
    private SignatureProvider signatureProvider;
    protected TimestampFormatter time;

    /**
     * Construct a request.
     * Parameters :
     *  'Format' and 'Signature' must not be provided.
     *  'Timestamp' may be omitted.
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

        this.params.put("Format", SDK_FORMAT);
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
     *
     * @param body
     * @param userId The ID of the user making the call.
     * @param secretKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     */
    public Request(Map<String, Object> body, String userId, String secretKey, String version) {
        this(
                body,
                new HashMap<String, String>(),
                secretKey
        );
        this.addParam("UserID", userId);
        this.addParam("Version", version);
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

    /**
     * Add a parameter to the request
     * @param key
     * @param value
     */
    protected void addParam(String key, String value) {
        this.params.put(key, value);
    }

    /**
     * Add multiple parameters to the request
     * @param opt
     */
    public void addOptions(Map<String, String> opt) {
        this.params.putAll(opt);
    }
}
