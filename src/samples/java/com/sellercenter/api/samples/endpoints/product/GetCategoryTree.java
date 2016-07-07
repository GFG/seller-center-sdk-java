package com.sellercenter.api.samples.endpoints.product;

import com.sellercenter.api.entities.Category;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

import java.util.Collection;

public class GetCategoryTree {

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

        /**
         * Pretty print the response
         */
        System.out.println("Success !");
        System.out.println();
        System.out.println("Category Tree :");
        for (Category cat : categories) {
            printCategoryTree(cat, 1);
        }
    }

    private static void printCategoryTree(Category cat, int depth) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; ++i) {
            res.append('\t');
        }
        res.append(cat.getString("Name"));
        System.out.println(res.toString());
        for(Category c : cat.getChildren()) {
            printCategoryTree(c, depth+1);
        }
    }
}
