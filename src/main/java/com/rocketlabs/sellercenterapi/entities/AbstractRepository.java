package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.core.request.Request;
import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.core.Client;
import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

import java.util.Map;

class AbstractRepository {

    SuccessResponse requestApi(String action) throws SdkException {
        return Client.call(new Request(action, SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version));
    }

    SuccessResponse requestApi(String action, Map<String, String> urlParams) throws SdkException {
        return Client.call(new Request(action, SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, urlParams));
    }

    SuccessResponse requestApi(String action, Map<String, String> urlParams, Map<String, Object> body) throws SdkException {
        return Client.call(new Request(action, SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, urlParams, body));
    }
}
