package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Order.Order;

import java.util.Map;

public class GetOrderResponse extends ConcreteResponse {

    private final Order order;

    /**
     * @inheritDoc
     */
    public GetOrderResponse(SuccessResponse response) {
        super(response);
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
