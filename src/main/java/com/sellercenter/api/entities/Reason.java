package com.sellercenter.api.entities;

import javax.json.JsonObject;

public class Reason extends AbstractModel {
    private final String type;
    private final String name;

    Reason(JsonObject r) {
        super(r);
        this.type = r.getString("Type");
        this.name = r.getString("Name");
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
