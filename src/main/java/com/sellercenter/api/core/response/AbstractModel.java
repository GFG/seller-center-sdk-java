package com.sellercenter.api.core.response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModel {
    protected Map<String, Object> data = new HashMap<String, Object>();

    public AbstractModel(Map<String, Object> data) {
        this.data.putAll(data);
    }

    public Map<String, Object> toMap() {
        return data;
    }

    /**
     *
     * @param key
     * @return
     */
    protected String getString(String key) {
        return (String) data.get(key);
    }

    /**
     *
     * @param key
     * @return
     */
    protected int getInt(String key) {
        return Integer.parseInt((String) data.get(key));
    }

    /**
     *
     * @param key
     * @return
     */
    protected float getFloat(String key) {
        return Float.parseFloat((String) data.get(key));
    }

    /**
     *
     * @param key
     * @return
     */
    protected Date getDate(String key) {
        return new Date(getString(key));
    }
}
