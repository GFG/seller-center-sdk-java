package com.rocketlabs.sellercenterapi.samples.endpoints.order;

import com.rocketlabs.sellercenterapi.entities.*;
import com.rocketlabs.sellercenterapi.samples.Config;

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
        // different ways for options
        ReadyToShipOptions options = (new ReadyToShipOptions())
                .setDeliveryToDropShipping(randomProvider, "123456789XYZ");

        (new ReadyToShipOptions())
                .setDeliveryType("Delivery Type");

        items.setStatusToReadyToShip(options);
    }
}
