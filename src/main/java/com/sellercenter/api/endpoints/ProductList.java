package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.response.SuccessResponse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ProductList extends AbstractModel implements Iterable<Product> {

    private final List<Product> products = new LinkedList<Product>();

    ProductList(SuccessResponse res) {
        super(res);

        Object product = (res.getObjectFromBody("Products")).get("Product");

        if (product instanceof List) {
            for (Map m : (List<Map>) product) {
                products.add(new Product(res, m));
            }
        } else if (product instanceof Map) {
            products.add(new Product(res, (Map) product));
        }
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
