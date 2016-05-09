package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.request.Get;

public class GetOrderRequest extends Get {

    /**
     * Constructor
     * @param userId The ID of the user making the call.
     * @param apiKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param orderId The order identifier that was assigned to the order by SellerCenter.
     */
    public GetOrderRequest(String userId, String apiKey, String version, int orderId) {
        super(userId, apiKey, version);
        this.addParam("Action", "GetOrder");
        this.addParam("OrderId", Integer.toString(orderId));
    }
}
