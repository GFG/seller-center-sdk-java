package com.sellercenter.api.entities;

import javax.json.JsonObject;

public class Reason extends AbstractModel {
    private final String id;

    Reason(JsonObject data) {
        super(data);
        id = data.getString("Name");
    }

    /**
     * Simple getter for the public id
     * @return public id of the reason
     */
    String getId() {
        return id;
    }
}
