package com.sellercenter.api.entities;

import com.sellercenter.api.core.utils.FormatAdapter;

import javax.json.Json;
import javax.json.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        try {
            return data.getInt(key);
        } catch (NullPointerException | ClassCastException e) {
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

    /**
     * Gets a date value of the given key
     * Return null if no value exist for this key
     * Or if value can't be a Date
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as Date
     */
    public Date getDate(String key) {
        if (getString(key) == null) {
            return null;
        }
        try {
            return new SimpleDateFormat().parse(getString(key));
        } catch (ParseException e) {
            return null;
        }
    }
}
