package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Order;

import java.util.Map;

public class GetOrderResponse extends SuccessResponse{

    private final Order order;

    /**
     * Constructor
     *
     * @param response the successful response returned by the client
     */
    public GetOrderResponse(SuccessResponse response) {
        super(response.getRequestAction(), response.getResponseType(), response.getTimestamp(), response.getBody());
        this.order = new Order(
                (Map<String, Object>) ((Map<String, Object>)response.getBody().get("Orders")).get("Order")
        );
    }

    /**
     * getter to order model
     *
     * @return order model
     */
    public Order getOrder() {
        return order;
    }
}
