package com.sellercenter.api.samples.endpoints.product;

import com.sellercenter.api.entities.Attribute;
import com.sellercenter.api.entities.Category;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

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
                att.append("    * ");
            } else {
                att.append("      ");
            }
            att.append(attribute.getIdentifier());
            System.out.println(att.toString());
        }
    }
}
