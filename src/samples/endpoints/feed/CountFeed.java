package endpoints.feed;

import com.sellercenter.api.endpoints.SellerCenter;
import com.sellercenter.api.endpoints.FeedCount;

public class CountFeed {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.userId = "remy.rey@rocket-internet.com";
        SellerCenter.url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Call the API
         */
        FeedCount feedCount = SellerCenter.feedCount();

        /**
         * Pretty print the response
         */
        System.out.println("FeedCount :");

        System.out.println("    Total       " + feedCount.getTotal());
        System.out.println("    Queued      " + feedCount.getQueued());
        System.out.println("    Processing  " + feedCount.getProcessing());
        System.out.println("    Finished    " + feedCount.getFinished());
        System.out.println("    Canceled    " + feedCount.getCanceled());
        System.out.println();
    }
}
