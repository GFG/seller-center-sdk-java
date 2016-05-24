package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;

import java.util.Map;

public interface SignatureProvider {

    /**
     * Sign a request by it's parameters
     *
     * @param params parameters of the request query
     * @return a string representing the signature of the request
     * @throws SdkException
     */
    String sign(Map<String, String> params) throws SdkException;

}
