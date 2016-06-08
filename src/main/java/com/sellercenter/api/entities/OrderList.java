package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class OrderList implements Iterable<Order> {
    private List<Order> orders = new LinkedList<>();
    private OrderItemRepository itemRepository = new OrderItemRepository();

    /**
     * @param response response from the API
     */
    OrderList(SuccessResponse response) {

        JsonValue orders = response.getBody().getJsonObject("Orders").get("Order");
        if (orders instanceof JsonArray) {
            for (JsonValue order : (JsonArray) orders) {
                if (order instanceof JsonObject) {
                    this.orders.add(new Order((JsonObject) order));
                }
            }
        } else if (orders instanceof JsonObject) {
            this.orders.add(new Order((JsonObject) orders));
        }
    }

    /**
     * Returns the items for one or more orders.
     *
     * @return list of order items
     * @throws SdkException
     */
    public OrderItemList getAllItems() throws SdkException {
        return this.itemRepository.retrieve(this);
    }

    /**
     * See interface Iterable
     *
     * @return iterator
     */
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    /**
     * Build and return the list of ids of all the orders
     *
     * @return list of ids
     */
    List<String> getIds() {
        List<String> ids = new LinkedList<>();
        for (Order o : orders) {
            ids.add(o.getOrderId());
        }
        return ids;
    }
}
