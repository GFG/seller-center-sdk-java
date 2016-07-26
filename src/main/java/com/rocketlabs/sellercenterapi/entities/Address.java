package com.rocketlabs.sellercenterapi.entities;

import javax.json.JsonObject;

/**
 * Model for addresses
 * Provide getters and setters to all attributes
 */
public final class Address extends AbstractModel {

    /**
     * Constructor
     *
     * @param data Json load from response body
     */
    public Address(JsonObject data) {
        super(data);
    }
}
