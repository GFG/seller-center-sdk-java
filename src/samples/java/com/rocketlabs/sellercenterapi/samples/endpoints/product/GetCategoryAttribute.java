package com.rocketlabs.sellercenterapi.samples.endpoints.product;

import com.rocketlabs.sellercenterapi.entities.Attribute;
import com.rocketlabs.sellercenterapi.entities.Category;
import com.rocketlabs.sellercenterapi.entities.SellerCenter;
import com.rocketlabs.sellercenterapi.samples.Config;

import java.util.Collection;

public class GetCategoryAttribute {

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

        System.out.println("Attributes for " + category.getString("Name"));
        System.out.println("('*' : mandatory)\n");
        for(Attribute attribute : attributes) {
            StringBuilder att = new StringBuilder();
            if (attribute.isMandatory()) {
                att.append("\t* ");
            } else {
                att.append("\t  ");
            }
            att.append(attribute.getIdentifier());
            System.out.println(att.toString());
        }
    }
}
