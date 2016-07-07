package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.*;
import com.sellercenter.api.samples.Config;

public class SetStatusToPackedByMarketplace {

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
         * Retrieve shipment providers
         */
        ShipmentProviderCollection providers = SellerCenter.getShipmentProviders();
        ShipmentProvider randomProvider = providers.iterator().next();

        /**
         * Set status
         */
        // with drop shipping
        PackedByMarketPlaceOptions options = (new PackedByMarketPlaceOptions())
                .setDeliveryToDropShipping(randomProvider);

        items.setStatusToPackedByMarketplace(options);
    }
}
