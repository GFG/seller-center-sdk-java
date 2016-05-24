package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.request.Post;
import com.sellercenter.api.core.utils.Helper;

import java.util.List;

public class SetStatusToPackedByMarketplaceRequest extends Post {

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param apiKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param orderItemIds List of oder items to be marked ready to ship
     * @param deliveryType One of the following : dropship, pickup, send_to_warehouse
     * @param shippingProvider Valid shipment provider as looked up via GetShipmentProviders
     */
    public SetStatusToPackedByMarketplaceRequest(
            String userId, String apiKey, String version,
            List<Integer> orderItemIds, String deliveryType, String shippingProvider) {
        super(null, userId, apiKey, version);
        addParam("Action", "SetStatusToPackedByMarketplace");
        addParam("OrderItemIds", Helper.toParam(orderItemIds));
        addParam("DeliveryType", deliveryType);
        addParam("ShippingProvider", shippingProvider);
    }
}
