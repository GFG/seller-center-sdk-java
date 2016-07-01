package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.ResponseDataException;
import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class OrderCollection implements Iterable<Order> {
    private List<Order> orders = new LinkedList<>();
    private OrderItemRepository itemRepository = new OrderItemRepository();

    /**
     * @param response response from the API
     */
    OrderCollection(SuccessResponse response) throws ResponseDataException {
        if (response.getBody().get("Orders") == null) {
            throw new ResponseDataException("Cannot create OrderCollection");
        }

        if (response.getBody().get("Orders") instanceof JsonObject) {
            if (response.getBody().getJsonObject("Orders").get("Order") == null) {
                throw new ResponseDataException("Cannot create OrderCollection");
            }

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
    }

    /**
     * Returns the items for one or more orders.
     *
     * @return list of order items
     * @throws SdkException
     */
    public OrderItemCollection getAllItems() throws SdkException {
        return itemRepository.retrieve(this);
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
            ids.add(o.getId());
        }
        return ids;
    }
}
