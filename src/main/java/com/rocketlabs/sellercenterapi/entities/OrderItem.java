package com.rocketlabs.sellercenterapi.entities;

import javax.json.JsonObject;

public final class OrderItem extends AbstractModel {

    /**
     * Constructor
     *
     * @param orderItem Json load from response body
     */
    OrderItem(JsonObject orderItem) {
        super(orderItem);
    }

    /**
     * ATTRIBUTES GETTERS AND SETTERS
     */

    public String getId() {
        return getString("OrderItemId");
    }

}
