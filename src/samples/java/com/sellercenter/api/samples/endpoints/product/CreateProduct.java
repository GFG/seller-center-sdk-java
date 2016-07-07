package com.sellercenter.api.samples.endpoints.product;

import com.sellercenter.api.entities.Attribute;
import com.sellercenter.api.entities.Category;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

import java.util.*;

public class CreateProduct {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = Config.apiKey;
        SellerCenter.userId = Config.userId;
        SellerCenter.url = Config.url;

        /**
         * Call the API
         */
        Collection<Category> categories = SellerCenter.getCategoryTree();
        Category category = categories.iterator().next();
        Collection<Attribute> attributes = category.getAttributes();


        List<Map> products = new LinkedList<>();
        Map<String, String> p = new HashMap<>();

        for (Attribute a : attributes) {
            if (a.isMandatory()) {
                p.put(a.getIdentifier(), "My " + a.getIdentifier());
            }
        }
        p.put("SellerSKU", "new sku");

        products.add(p);
        SellerCenter.createProduct(products);
    }

}
