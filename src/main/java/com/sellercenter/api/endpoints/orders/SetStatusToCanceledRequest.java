package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.request.Post;

import java.util.HashMap;

public class SetStatusToCanceledRequest extends Post{

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param apiKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param orderItemId The order identifier that was assigned to the order by SellerCenter.
     * @param reason
     * @param reasonDetail
     */
    public SetStatusToCanceledRequest(
            String userId,
            String apiKey,
            String version,
            int orderItemId,
            String reason,
            String reasonDetail
    ) {
        super(new HashMap<String, Object>(), userId, apiKey, version);
        this.addParam("Action", "SetStatusToCanceled");
        this.addParam("OrderItemId", Integer.toString(orderItemId));
        this.addParam("Reason", reason);
        this.addParam("ReasonDetail", reasonDetail);
    }
}
