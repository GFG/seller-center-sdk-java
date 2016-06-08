package com.rocketlabs.sellercenterapi.entities;

import javax.json.JsonObject;

public class ShipmentProvider extends AbstractModel {
    private final String id;

    ShipmentProvider(JsonObject data) {
        super(data);
        id = getString("Name");
    }

    public String getId() {
        return id;
    }
}
