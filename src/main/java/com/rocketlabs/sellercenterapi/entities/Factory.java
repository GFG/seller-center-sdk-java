package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;
import com.rocketlabs.sellercenterapi.exceptions.ResponseDataException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;

class Factory {

    /**
     *
     * @param response
     * @return
     */
    static Collection<Attribute> createAttributeCollection(SuccessResponse response) throws ResponseDataException {
        JsonValue attribute = response.getBody().get("Attribute");

        Collection<Attribute> attributes = new ArrayList<>();
        if (attribute instanceof JsonArray) {
            for (JsonValue att : (JsonArray) attribute) {
                if (att instanceof JsonObject) {
                    attributes.add(new Attribute((JsonObject) att));
                }
            }
        } else if (attribute instanceof JsonObject) {
            attributes.add(new Attribute((JsonObject) attribute));
        }
        return attributes;
    }

    /**
     *
     * @param response
     * @return
     */
    static Collection<Category> createCategoryCollection(SuccessResponse response) throws ResponseDataException {
        JsonObject categories = response.getBody().getJsonObject("Categories");
        if (categories == null) {
            throw new ResponseDataException("Can't create category collection from response");
        }
        return createCategoryCollection(categories);
    }

    /**
     *
     * @param data Json data representing a set of categories
     * @return
     */
    static Collection<Category> createCategoryCollection(JsonValue data) throws ResponseDataException {
        Collection<Category> categories = new ArrayList<>();

        if (data instanceof JsonObject) {
            JsonValue category = ((JsonObject) data).get("Category");
            if (category == null) {
                throw new ResponseDataException("Cannot create category collection");
            }
            if (category instanceof JsonArray) {
                for (JsonValue cat : ((JsonArray) category)) {
                    if (cat instanceof JsonObject) {
                        categories.add(new Category((JsonObject) cat));
                    }
                }
            } else if (category instanceof JsonObject) {
                categories.add(new Category((JsonObject) category));
            }
        }

        return categories;
    }
}
