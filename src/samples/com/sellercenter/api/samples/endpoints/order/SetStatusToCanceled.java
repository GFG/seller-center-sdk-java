package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.*;
import com.sellercenter.api.samples.Config;

public class SetStatusToCanceled {
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
        items.setStatusToCanceled(randomReason, "Reason detail");
    }
}
