package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.response.SuccessResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractModel {
    protected final SuccessResponse response;
    protected Map<String, Object> data = new HashMap<String, Object>();

    public AbstractModel(SuccessResponse res) {
        this.response = res;
    }

    public Map<String, Object> toMap() {
        return data;
    }

    /**
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as string
     */
    String getString(String key) {
        return (String) data.get(key);
    }

    /**
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as int
     */
    int getInt(String key) {
        return Integer.parseInt((String) data.get(key));
    }

    /**
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as float
     */
    float getFloat(String key) {
        return Float.parseFloat((String) data.get(key));
    }

    /**
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped as Date
     */
    Date getDate(String key) {
        try {
            return new SimpleDateFormat().parse(getString(key));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     *
     * @return last response that affected this model
     */
    public SuccessResponse getLastResponse() {
        return response;
    }

}
