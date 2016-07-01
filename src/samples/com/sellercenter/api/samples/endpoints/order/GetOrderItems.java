package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.GetOrdersOptions;
import com.sellercenter.api.entities.OrderItem;
import com.sellercenter.api.entities.OrderItemCollection;
import com.sellercenter.api.entities.SellerCenter;
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
        OrderItemCollection items = SellerCenter.getOrders(opt).getAllItems();

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
            System.out.println("    |   Name:   " + item.getString("Name"));
            System.out.println("    |   Status: " + item.getString("Status"));
            System.out.println();
        }
    }
}
