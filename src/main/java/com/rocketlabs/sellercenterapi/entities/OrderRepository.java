package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

import java.util.HashMap;
import java.util.Map;

class OrderRepository extends AbstractRepository {

    /**
     * Perform api call to get a list of orders
     * under the options constraint
     *
     * @param options optional request parameters
     * @return list of the customer details for a range of orders
     * @throws SdkException
     */
    OrderCollection retrieve(GetOrdersOptions options) throws SdkException {
        SuccessResponse response = requestApi("GetOrders", options.toMap());
        return new OrderCollection(response);
    }

    /**
     * Perform API call to get order which orderId is specified
     *
     * @return list of the customer details for a range of orders
     * @throws SdkException
     */
    Order retrieve(String id) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderId", id);
        SuccessResponse response = requestApi("GetOrder", params);

        return new Order(response);
    }

    ReasonCollection getFailureReasons() throws SdkException {
        SuccessResponse response = requestApi("GetFailureReasons");
        return new ReasonCollection(response);
    }

    ShipmentProviderCollection getShipmentProviders() throws SdkException {
        SuccessResponse response = requestApi("GetShipmentProviders");
        return new ShipmentProviderCollection(response);
    }
}
