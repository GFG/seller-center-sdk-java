package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.GetOrdersOptions;
import com.sellercenter.api.entities.OrderItemCollection;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

public class SetStatusToShipped {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = Config.apiKey;
        SellerCenter.userId = Config.userId;
        SellerCenter.url = Config.url;

        /**
         * Retrieve items
         */
        GetOrdersOptions opt = new GetOrdersOptions();
        opt.setLimit(1);
        // ... set other options
        OrderItemCollection items = SellerCenter.getOrders(opt).getAllItems();

        /**
         * Set status
         */
        items.setStatusToShipped();
    }
}
