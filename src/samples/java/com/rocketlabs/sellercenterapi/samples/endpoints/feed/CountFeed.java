package com.rocketlabs.sellercenterapi.samples.endpoints.feed;

import com.rocketlabs.sellercenterapi.entities.FeedCount;
import com.rocketlabs.sellercenterapi.entities.SellerCenter;
import com.rocketlabs.sellercenterapi.samples.Config;

public class CountFeed {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = Config.apiKey;
        SellerCenter.userId = Config.userId;
        SellerCenter.url = Config.url;

        /**
         * Call the API
         */
        FeedCount feedCount = SellerCenter.feedCount();

        /**
         * Pretty print the response
         */
        System.out.println("FeedCount :");

        System.out.println("    Total       " + feedCount.getInt("Total"));
        System.out.println("    Queued      " + feedCount.getInt("Queued"));
        System.out.println("    Processing  " + feedCount.getInt("Processing"));
        System.out.println("    Finished    " + feedCount.getInt("Finished"));
        System.out.println("    Canceled    " + feedCount.getInt("Canceled"));
        System.out.println();
    }
}
