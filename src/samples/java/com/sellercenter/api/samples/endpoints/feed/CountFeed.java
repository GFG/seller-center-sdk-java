package com.sellercenter.api.samples.endpoints.feed;

import com.sellercenter.api.entities.FeedCount;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

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
