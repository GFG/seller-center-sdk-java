package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.*;
import com.sellercenter.api.samples.Config;

public class GetOrderItems {
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
        OrderItemList items = SellerCenter.getOrders(opt).getAllItems();

        /**
         * Pretty print the response
         */
        System.out.println("Success !");

        System.out.println();
        System.out.println("Order Items :");
        System.out.println();
        for (OrderItem item : items) {
            System.out.println("    Item:");
            System.out.println("    |   Id:     " + item.getId());
            System.out.println("    |   Name:   " + item.getName());
            System.out.println("    |   Status: " + item.getStatus());
            System.out.println();
        }
    }
}
