package com.sellercenter.api.entities;

import javax.json.JsonObject;

public class ShipmentProvider extends AbstractModel {
    ShipmentProvider(JsonObject data) {
        super(data);
    }

    public String getName() {
        return this.getString("Name");
    }
}
