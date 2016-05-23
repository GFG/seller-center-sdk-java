package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Request implements com.sellercenter.api.core.Request {

    private final static String SDK_FORMAT = "JSON";
    private Map<String, Object> body;
    private Map<String,String> params;
    private SignatureProvider signatureProvider;
    private Method method;
    private TimestampFormatter time;

    /**
     *
     * @param action Name of the function that is to be called
     * @param userId ID of the user making the call.
     * @param apiKey API key of the user specified in the UserID parameter.
     * @param version API version against which this call is to be executed, in major-dot-minor format.
     */
    public Request(
        String action,
        String userId,
        String apiKey,
        String version
    ) {
        this.signatureProvider = new HashHmacSignatureProvider(apiKey);
        this.time = new TimestampFormatter();

        this.method = Method.GET;

        this.params = new HashMap<String, String>();
        this.params.put("Version", version);
        this.params.put("UserID", userId);
        this.params.put("Format", SDK_FORMAT);
        this.params.put("Action", action);
        updateTimestamp(new Date());

    }

    /**
     *
     * @param action Name of the function that is to be called
     * @param userId ID of the user making the call.
     * @param apiKey API key of the user specified in the UserID parameter.
     * @param version API version against which this call is to be executed, in major-dot-minor format.
     * @param params Optional parameters
     */
    public Request(
            String action,
            String userId,
            String apiKey,
            String version,
            Map<String, String> params
    ) {
        this(action, userId, apiKey, version);
        this.params.putAll(params);
    }

    /**
     *
     * @param action Name of the function that is to be called
     * @param userId ID of the user making the call.
     * @param apiKey API key of the user specified in the UserID parameter.
     * @param version API version against which this call is to be executed, in major-dot-minor format.
     * @param params Optional parameters
     * @param body Body of the request
     */
    public Request(
            String action,
            String userId,
            String apiKey,
            String version,
            Map<String, String> params,
            Map<String, Object> body
    ) {
        this(action, apiKey, userId, version, params);
        this.method = Method.POST;
        this.body = body;
    }

    /**
     *
     * @return http method
     */
    public Method getMethod() {
        return this.method;
    }

    /**
     * Returns the body of a the request
     * @return Map of the body, as passed to the constructor if POST request, null if GET request
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
    private void updateTimestamp(Date now) {
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
