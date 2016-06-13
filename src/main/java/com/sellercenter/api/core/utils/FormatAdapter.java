package com.sellercenter.api.core.utils;

import org.json.JSONObject;
import org.json.XML;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatAdapter {

    /**
     * Convert a Map representing data
     * to a XML string
     *
     * @param container map representing the data
     * @param name      name of the envelope for the container
     * @return xml as a string
     */
    public static String toXML(Map<String, Object> container, String name) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + XML.toString(new JSONObject(container), name);
    }

    /**
     * Convert a Json object to a Map of the data
     *
     * @param json a Json object
     * @return map representing the object
     */
    public static Map<String, Object> jsonToMap(JsonObject json) {
        Map<String, Object> map = new HashMap<>();

        for (String key : json.keySet()) {
            map.put(key, valueToObject(json.get(key)));
        }

        return map;
    }

    /**
     * Convert a Json array to a Map of the data
     *
     * @param array a Json array
     * @return list representing the array
     */
    private static List<Object> jsonArrayToList(JsonArray array) {
        List<Object> list = new ArrayList<>();

        for (Object value : array) {
            list.add(valueToObject(value));
        }

        return list;
    }

    /**
     * Convert a Json value to a Map of the data
     *
     * @param value any kind of json object
     * @return an object representing the json (map, array or primitive)
     */
    private static Object valueToObject(Object value) {
        if (value instanceof JsonObject) {
            return jsonToMap((JsonObject) value);
        } else if (value instanceof JsonArray) {
            return jsonArrayToList((JsonArray) value);
        } else if (value instanceof JsonString){
            return ((JsonString) value).getString();
        } else {
            return null;
        }
    }
}
