package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.request.Get;

public class GetOrdersRequest extends Get{

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param apiKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param opt Optional parameters. @see com.sellercenter.api.endpoints.orders.GetOrdersOptions GetOrdersOptions
     */
    public GetOrdersRequest(String userId, String apiKey, String version, GetOrdersOptions opt) {
        super(userId, apiKey, version);
        addParam("Action", "GetOrders");
        addOptions(opt.toMap());
    }
}
