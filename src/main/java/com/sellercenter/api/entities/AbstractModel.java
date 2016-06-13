package com.sellercenter.api.entities;

import com.sellercenter.api.core.utils.FormatAdapter;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.Map;

abstract class AbstractModel {
    final JsonObject data;

    AbstractModel(JsonObject data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = Json.createObjectBuilder().build();
        }
    }

    public Map<String, Object> toMap() {
        return FormatAdapter.jsonToMap(data);
    }

    /**
     * Get a string value of the given key
     * Return null if no value exist for this key
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as string
     */
    public String getString(String key) {
        try {
            return data.getString(key);
        } catch (NullPointerException | ClassCastException e) {
            return null;
        }
    }

    /**
     * Get a integer value of the given key
     * Return null if no value exist for this key
     * Or if value can't be an Integer
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as int
     */
    public Integer getInt(String key) {
        if (getString(key) == null) {
            return null;
        }
        try {
            return Integer.parseInt(getString(key));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Get a float value of the given key
     * Return null if no value exist for this key
     * Or if value can't be a Float
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as float
     */
    public Float getFloat(String key) {
        if (getString(key) == null) {
            return null;
        }
        try {
            return Float.parseFloat(getString(key));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
