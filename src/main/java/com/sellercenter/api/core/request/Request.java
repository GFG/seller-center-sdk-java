package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Request implements com.sellercenter.api.core.Request {

    /**
     * Response format accepted by the SDK
     */
    private final static String SDK_FORMAT = "JSON";

    /**
     * Body of the request
     * null for GET requests
     */
    private Map<String, Object> body;

    /**
     * Parameters of the request
     */
    private Map<String, String> params;

    /**
     * To sign request according to API documentation
     */
    private SignatureProvider signatureProvider;

    /**
     * HTTP Method of the request
     */
    private Method method;

    /**
     * To timestamp the request according to API documentation
     */
    private TimestampFormatter time;

    /**
     * Constructor for GET request
     *
     * @param action  Name of the function that is to be called
     * @param userId  ID of the user making the call.
     * @param apiKey  API key of the user specified in the UserID parameter.
     * @param version API version against which this call is to be executed, in major-dot-minor format.
     */
    public Request(
            String action,
            String userId,
            String apiKey,
            String version
    ) {
        signatureProvider = new HashHmacSignatureProvider(apiKey);
        time = new TimestampFormatter();

        method = Method.GET;

        params = new HashMap<>();
        params.put("Version", version);
        params.put("UserID", userId);
        params.put("Format", SDK_FORMAT);
        params.put("Action", action);
        updateTimestamp();

    }

    /**
     * Constructor for GET request with additional parameters
     *
     * @param action  Name of the function that is to be called
     * @param userId  ID of the user making the call.
     * @param apiKey  API key of the user specified in the UserID parameter.
     * @param version API version against which this call is to be executed, in major-dot-minor format.
     * @param urlParams  Optional parameters
     */
    public Request(
            String action,
            String userId,
            String apiKey,
            String version,
            Map<String, String> urlParams
    ) {
        this(action, userId, apiKey, version);
        params.putAll(urlParams);
    }

    /**
     * Constructor for POST request
     *
     * @param action  Name of the function that is to be called
     * @param userId  ID of the user making the call.
     * @param apiKey  API key of the user specified in the UserID parameter.
     * @param version API version against which this call is to be executed, in major-dot-minor format.
     * @param urlParams  Optional parameters
     * @param body    Body of the request
     */
    public Request(
            String action,
            String userId,
            String apiKey,
            String version,
            Map<String, String> urlParams,
            Map<String, Object> body
    ) {
        this(action, userId, apiKey, version, urlParams);
        method = Method.POST;
        this.body = body;
    }

    /**
     * Return the method suited for that request
     *
     * @return http method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Returns the body of a the request
     *
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
     */
    private void updateTimestamp() {
        String date = time.getTimestamp(new Date());
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
