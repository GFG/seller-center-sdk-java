package com.sellercenter.api.core.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatAdapter {

    /**
     *
     * @param container map representing the data
     * @param name name of the envelope for the container
     * @return xml as a string
     */
    public static String toXML(Map<String, Object> container, String name) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + XML.toString(new JSONObject(container), name);
    }

    public static Map<String, Object> fromJSON(String jsonString) {
        return jsonToMap(new JSONObject(jsonString));
    }

    /**
     *
     * @param json a Json object
     * @return map representing the object
     */
    private static Map<String, Object> jsonToMap(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();

        for (String key : json.keySet()) {
            map.put(key, valueToObject(json.get(key)));
        }

        return map;
    }

    /**
     *
     * @param array a Json array
     * @return list representing the array
     */
    private static List<Object> jsonArrayToList(JSONArray array) {
        List<Object> list = new ArrayList<Object>();

        for (Object value : array) {
            list.add(valueToObject(value));
        }

        return list;
    }

    /**
     *
     * @param value any kind of json object
     * @return an object representing the json (map, array or primitive)
     */
    private static Object valueToObject(Object value) {
        if (value instanceof JSONObject) {
            return jsonToMap((JSONObject) value);
        } else if (value instanceof JSONArray) {
            return jsonArrayToList((JSONArray) value);
        } else {
            return value;
        }
    }
}
