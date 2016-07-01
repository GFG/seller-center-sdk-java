package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.ResponseDataException;
import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.*;

public final class ProductList implements Iterable<Product> {

    private final List<Product> products = new LinkedList<>();
    private ProductRepository repository = new ProductRepository();

    /**
     * Constructor
     *
     * @param res response from the api
     */
    ProductList(SuccessResponse res) throws ResponseDataException {
        if (res.getBody().getJsonObject("Products") == null
                || res.getBody().getJsonObject("Products").get("Product") == null) {
            throw new ResponseDataException("Cannot create Product List");
        }
        JsonValue product = res.getBody().getJsonObject("Products").get("Product");

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
     *
     * @throws SdkException
     */
}
