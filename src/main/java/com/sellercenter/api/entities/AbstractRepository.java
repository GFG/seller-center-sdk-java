package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

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
