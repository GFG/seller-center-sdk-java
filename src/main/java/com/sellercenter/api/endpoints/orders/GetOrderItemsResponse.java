package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Order.Order;
import com.sellercenter.api.models.Order.OrderItem;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetOrderItemsResponse extends ConcreteResponse {

    private final List<OrderItem> itemList = new LinkedList<OrderItem>();

    /**
     * @inheritDoc
     */
    public GetOrderItemsResponse(SuccessResponse successResponse) {
        super(successResponse);
        Object items = ((Map<String, Object>) getBody().get("OrderItems")).get("OrderItem");
        if (items instanceof List) {
            for(Object item : (List) items) {
                if (item instanceof Map) {
                    itemList.add(new OrderItem((Map<String, Object>) item));
                }
            }
        } else if (items instanceof Map) {
            itemList.add(new OrderItem((Map) items));
        }
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
