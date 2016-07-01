package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.Document;
import com.sellercenter.api.entities.GetOrdersOptions;
import com.sellercenter.api.entities.OrderItemCollection;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

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
