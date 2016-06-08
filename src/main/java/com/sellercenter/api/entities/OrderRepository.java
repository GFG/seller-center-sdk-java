package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import java.util.HashMap;
import java.util.Map;

class OrderRepository {

    /**
     * Perform api call to get a list of orders
     * under the options constraint
     *
     * @param options optional request parameters
     * @return list of the customer details for a range of orders
     * @throws SdkException
     */
    OrderList retrieve(GetOrdersOptions options) throws SdkException {
        SuccessResponse response = Client.call(
                new Request("GetOrders", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, options.toMap())
        );
        return new OrderList(response);
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
        SuccessResponse response = Client.call(
                new Request("GetOrder", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new Order(response);
    }

    ReasonList getFailureReasons() throws SdkException {
        SuccessResponse response = Client.call(
                new Request("GetFailureReasons", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version)
        );
        return new ReasonList(response);
    }

    ShipmentProviderList getShipmentProviders() throws SdkException {
        SuccessResponse response = Client.call(
                new Request("GetShipmentProviders", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version)
        );
        return new ShipmentProviderList(response);
    }
}
