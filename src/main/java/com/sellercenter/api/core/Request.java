package com.sellercenter.api.core;

import com.sellercenter.api.exceptions.SdkException;

import java.util.Map;

public interface Request {

    String GET = "GET";
    String POST = "POST";

    /**
     * Should return GET or POST depending on the action
     * cf. documentation
     *
     * @return Method of the request.
     */
    String getMethod();

    /**
     * Get the body of the request, in a JSON like representation,
     * including List<Object> and primitive value Object.
     *
     * @return A map representing the content of the body
     */
    Map<String, Object> getBody();

    /**
     * Get parameters of the request
     *
     * @return a map representing the parameters of a request.
     * Always include : Action, Timestamp, UserID, Version, Signature
     * Can include additionnal parameters (ie search for GetProducts)
     */
    Map<String,String> getParams() throws SdkException;
}
