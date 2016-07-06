package com.sellercenter.api.entities;

import com.sellercenter.api.core.utils.Helper;
import com.sellercenter.api.exceptions.SdkException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReadyToShipOptions {

    private static final String DROP_SHIP = "dropship";
    private String deliveryType;
    private ShipmentProvider shippingProvider;
    private String trackingNumber;
    private List<String> serialNumbers = new LinkedList<>();

    /**
     *
     * @param type Type of delivery
     * @return the calling instance for chaining
     * @throws SdkException
     */
    public ReadyToShipOptions setDeliveryType(String type) throws SdkException {
        if (!Objects.equals(deliveryType, DROP_SHIP)) {
            throw new SdkException("Please use setToDropShipping method instead of setDeliveryType for Dropshipping");
        }
        deliveryType = type;
        return this;
    }

    /**
     *
     * @param shippingProvider Valid shipment provider as looked up via GetShipmentProviders
     * @param trackingNumber Tracking number
     * @return the calling instance for chaining
     */
    public ReadyToShipOptions setDeliveryToDropShipping(ShipmentProvider shippingProvider, String trackingNumber) {
        deliveryType = DROP_SHIP;
        this.shippingProvider = shippingProvider;
        this.trackingNumber = trackingNumber;
        return this;
    }

    /**
     *
     * @param numbers Unique serial numbers for tracking order items
     * @return the calling instance for chaining
     */
    public ReadyToShipOptions setSerialNumbers(List<String> numbers) {
        serialNumbers.addAll(numbers);
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
            map.put("ShippingProvider", shippingProvider.getId());
        }
        if (trackingNumber != null) {
            map.put("TrackingNumber", trackingNumber);
        }
        if (serialNumbers != null) {
            map.put("Offset", Helper.toParam(serialNumbers));
        }
        return map;
    }
}
