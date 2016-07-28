package com.rocketlabs.sellercenterapi.entities;

import javax.json.JsonObject;

/**
 * Sub-model for ProductData in a Product
 * Provide getters and setters to all attributes
 */
public final class ProductData extends AbstractModel {

    /**
     * Constructor
     *
     * @param data Json load from response body
     */
    ProductData(JsonObject data) {
        super(data);
    }

}

