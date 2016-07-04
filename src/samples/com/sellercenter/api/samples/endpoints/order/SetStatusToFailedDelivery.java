package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.*;
import com.sellercenter.api.samples.Config;

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
        OrderItemList items = SellerCenter.getOrders(opt).getAllItems();

        /**
         * retrieve failure reasons
         */
        ReasonList reasons = SellerCenter.GetFailureReasons();
        Reason randomReason = reasons.iterator().next();

        /**
         * Set status
         */
        items.setStatusToFailedDelivery(randomReason, "I have my reasons to give you that reason");
    }
}
