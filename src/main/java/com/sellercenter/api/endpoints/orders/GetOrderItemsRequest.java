package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.request.Get;

public class GetOrderItemsRequest extends Get{

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param apiKey The API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param orderId The order identifier that was assigned to the order by SellerCenter
     */
    public GetOrderItemsRequest(String userId, String apiKey, String version, int orderId) {
        super(userId, apiKey, version);
        addParam("Action", "GetOrderItems");
        addParam("OrderId", Integer.toString(orderId));
    }
}
