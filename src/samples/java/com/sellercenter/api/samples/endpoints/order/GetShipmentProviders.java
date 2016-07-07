package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.entities.ShipmentProvider;
import com.sellercenter.api.entities.ShipmentProviderCollection;
import com.sellercenter.api.samples.Config;

public class GetShipmentProviders {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = Config.apiKey;
        SellerCenter.userId = Config.userId;
        SellerCenter.url = Config.url;

        /**
         * Get Reasons
         */
        ShipmentProviderCollection providers = SellerCenter.getShipmentProviders();

        /**
         * Pretty print the response
         */
        System.out.println("Success !");

        System.out.println();
        System.out.println("Shipment Providers: ");
        System.out.println();
        for (ShipmentProvider provider : providers) {
            System.out.println("Provider :  " + provider.getString("Name"));
            System.out.println(provider.toString());
            System.out.println();
        }
    }
}
