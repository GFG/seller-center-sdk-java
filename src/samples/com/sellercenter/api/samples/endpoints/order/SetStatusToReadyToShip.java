package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.GetOrdersOptions;
import com.sellercenter.api.entities.OrderItemList;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

public class SetStatusToReadyToShip {

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
        items.setStatusToReadyToShip();

        /**
         * Pretty print the response
         */
        System.out.println("Success !\n");
    }
}
