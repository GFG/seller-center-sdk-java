package com.rocketlabs.sellercenterapi.samples.endpoints.order;

import com.rocketlabs.sellercenterapi.entities.Document;
import com.rocketlabs.sellercenterapi.entities.GetOrdersOptions;
import com.rocketlabs.sellercenterapi.entities.OrderItemCollection;
import com.rocketlabs.sellercenterapi.entities.SellerCenter;
import com.rocketlabs.sellercenterapi.samples.Config;

public class GetDocument {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = Config.apiKey;
        SellerCenter.userId = Config.userId;
        SellerCenter.url = Config.url;

        /**
         * Perform the API call
         */
        GetOrdersOptions opt = new GetOrdersOptions();
        opt.setLimit(1);
        OrderItemCollection items = SellerCenter.getOrders(opt).getAllItems();
        Document doc = items.getDocument("ShippingParcel");


        /**
         * Pretty print the response
         */
        System.out.println("Success !");

        System.out.println();
        System.out.println("Document: " + doc.getFile());
        System.out.println();
    }
}
