package com.sellercenter.api.entities;

import javax.json.JsonObject;
import java.util.Date;

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
