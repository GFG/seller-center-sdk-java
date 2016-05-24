package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Order.Order;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetOrdersResponse extends ConcreteResponse {

    private List<Order> orderList = new LinkedList<Order>();

    /**
     * @inheritDoc
     */
    public GetOrdersResponse(SuccessResponse successResponse) {
        super(successResponse);
        Object orders = ((Map<String, Object>) getBody().get("Orders")).get("Order");
        if (orders instanceof List) {
            for(Object order : (List) orders) {
                if (order instanceof Map) {
                    orderList.add(new Order((Map<String, Object>) order));
                }
            }
        } else if (orders instanceof Map) {
            orderList.add(new Order((Map) orders));
        }
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
