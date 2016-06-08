package com.sellercenter.api.entities;

import com.sellercenter.api.exceptions.SdkException;

import java.util.HashMap;
import java.util.Map;

public class PackedByMarketPlaceOptions {

    private static final String DROP_SHIP = "dropship";
    private String deliveryType;
    private ShipmentProvider shippingProvider;

    /**
     *
     * @param type Type of delivery
     * @return the calling instance for chaining
     * @throws SdkException
     */
    public PackedByMarketPlaceOptions setDeliveryType(String type) throws SdkException {
        if (this.deliveryType.equals(DROP_SHIP)) {
            throw new SdkException("Please use setToDropShipping method instead of setDeliveryType for Dropshipping");
        }
        this.deliveryType = type;
        return this;
    }

    /**
     *
     * @param shippingProvider Valid shipment provider as looked up via GetShipmentProviders
     * @return the calling instance for chaining
     */
    public PackedByMarketPlaceOptions setDeliveryToDropShipping(ShipmentProvider shippingProvider) {
        this.deliveryType = DROP_SHIP;
        this.shippingProvider = shippingProvider;
        return this;
    }

    /**
     * Build a map representing the optional parameters of the request.
     * All parameters are formatted to the API requirement.
     *
     * @return map of optional parameters
     */
    Map<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        if (deliveryType != null) {
            map.put("DeliveryType", deliveryType);
        }
        if (shippingProvider != null) {
            map.put("ShippingProvider", shippingProvider.getName());
        }
        return map;
    }
}
