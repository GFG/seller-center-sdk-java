package com.sellercenter.api.endpoints.products;

import com.sellercenter.api.core.request.Get;

public class GetProductsRequest extends Get {

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param secretKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param opt Optional parameters to filter the request
     */
    public GetProductsRequest(String userId, String secretKey, String version, GetProductsOptions opt) {
        super(userId, secretKey, version);
        this.addParam("Action", "GetProducts");
        this.addOptions(opt.toMap());
    }

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param secretKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     */
    public GetProductsRequest(String userId, String secretKey, String version) {
        super(userId, secretKey, version);
        this.addParam("Action", "GetProducts");
    }
}
