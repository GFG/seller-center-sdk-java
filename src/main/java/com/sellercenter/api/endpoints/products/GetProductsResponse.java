package com.sellercenter.api.endpoints.products;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetProductsResponse extends ConcreteResponse {

    private final List<Product> products = new LinkedList<Product>();

    /**
     * Constructor
     *
     * @param response the successful response returned by the client
     */
    public GetProductsResponse(SuccessResponse response) {
        super(response);
        Object product = ((Map<String, Object>) getBody().get("Products")).get("Product");

        if (product instanceof List) {
            List<Map> list = (List<Map>) product;
            for (Map m : list) {
                products.add(new Product(m));
            }
        } else if (product instanceof Map) {
            products.add(new Product((Map<String, Object>) product));
        }


    }

    /**
     * Simple getter for products
     *
     * @return a list of product
     */
    public List<Product> getProducts() {
        return products;
    }
}
