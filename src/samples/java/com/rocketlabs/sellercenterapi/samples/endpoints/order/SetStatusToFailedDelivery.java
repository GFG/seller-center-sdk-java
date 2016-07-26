package com.rocketlabs.sellercenterapi.samples.endpoints.order;

import com.rocketlabs.sellercenterapi.entities.*;
import com.rocketlabs.sellercenterapi.samples.Config;

public class SetStatusToFailedDelivery {

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
         * retrieve failure reasons
         */
        ReasonCollection reasons = SellerCenter.getFailureReasons();
        Reason randomReason = reasons.iterator().next();

        /**
         * Set status
         */
        items.setStatusToFailedDelivery(randomReason, "I have my reasons to give you that reason");
    }
}
