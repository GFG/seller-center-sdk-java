package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.*;

public final class ProductList implements Iterable<Product> {

    private final List<Product> products = new LinkedList<>();

    /**
     * Constructor
     *
     * @param res response from the api
     */
    ProductList(SuccessResponse res) {
        JsonObject body = res.getBody();
        JsonValue product = body.getJsonObject("Products").get("Product");

        if (product instanceof JsonArray) {
            for (JsonValue p : (JsonArray) product) {
                if (p instanceof JsonObject) {
                    products.add(new Product((JsonObject) p));
                }
            }
        } else if (product instanceof JsonObject) {
            products.add(new Product((JsonObject) product));
        }
    }

    /**
     * For interface Iterable
     *
     * @return iterator instance
     */
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    /**
     * Return a map of changes in product to be updated in Seller Center
     *
     * @return map representing all products
     */
    public Map<String, Object> toMap() {
        return new HashMap<>();
    }
}
