package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;

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
    static Collection<Attribute> createAttributeCollection(SuccessResponse response) {
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
    static Collection<Category> createCategoryCollection(SuccessResponse response) {
        JsonValue category = response.getBody().getJsonObject("Categories").get("Category");
        return createCategoryCollection(category);
    }

    /**
     *
     * @param data Json data representing a set of categories
     * @return
     */
    static Collection<Category> createCategoryCollection(JsonValue data) {
        Collection<Category> categories = new ArrayList<>();

        if (data instanceof JsonArray) {
            for(JsonValue cat : ((JsonArray) data)) {
                if (cat instanceof JsonObject) {
                    categories.add(new Category((JsonObject) cat));
                }
            }
        } else if (data instanceof JsonObject) {
            categories.add(new Category((JsonObject) data));
        }

        return categories;
    }
}
