package com.sellercenter.api.samples.endpoints.product;

import com.sellercenter.api.entities.GetProductsOptions;
import com.sellercenter.api.entities.Product;
import com.sellercenter.api.entities.ProductCollection;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

public class GetProducts {

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
        GetProductsOptions opt = new GetProductsOptions();
        opt.setLimit(2).addSku("7878");
        ProductCollection products = SellerCenter.getProducts(opt);

        /**
         * Pretty print the response
         */
        System.out.println("Success !");
        System.out.println();
        System.out.println("Products :");
        for (Product p : products) {
            System.out.println("");
            System.out.println("\t" + p.getString("Name"));
            System.out.println("\t|   sku:      " + p.getString("SellerSku"));
            System.out.println("\t|   Category: " + p.getString("PrimaryCategory"));
            System.out.println("\t|   price:    " + p.getString("Price"));
            System.out.println("\t|   Image:    " + p.getString("MainImage"));
        }
    }
}
