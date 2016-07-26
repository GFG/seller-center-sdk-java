package com.rocketlabs.sellercenterapi.core.request;

import com.rocketlabs.sellercenterapi.exceptions.SdkException;

import java.util.Map;

interface SignatureProvider {

    /**
     * Sign a request by it's parameters
     *
     * @param params parameters of the request query
     * @return a string representing the signature of the request
     * @throws SdkException
     */
    String sign(Map<String, String> params) throws SdkException;

}
