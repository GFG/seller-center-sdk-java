package com.sellercenter.api.entities;

import com.sellercenter.api.core.utils.FormatAdapter;

import javax.json.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

abstract class AbstractModel {
    final JsonObject data;

    AbstractModel(JsonObject data) {
        this.data = data;
    }

    public Map<String, Object> toMap() {
        return FormatAdapter.jsonToMap(data);
    }

    /**
     * Get a string value of the given key
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as string
     */
    public String getString(String key) {
        return data.getString(key);
    }

    /**
     * Get a integer value of the given key
     * Fails if the value can't be converted
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as int
     */
    public int getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    /**
     * Get a float value of the given key
     * Fails if the value can't be converted
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as float
     */
    public float getFloat(String key) {
        return Float.parseFloat(getString(key));
    }

    /**
     * Gets a date value of the given key
     * Fails if the value can't be converted
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as Date
     */
    public Date getDate(String key) {
        try {
            return new SimpleDateFormat().parse(getString(key));
        } catch (ParseException e) {
            return null;
        }
    }
}
