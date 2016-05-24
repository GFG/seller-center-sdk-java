package endpoints.feed;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.endpoints.Feeds;
import com.sellercenter.api.endpoints.feed.FeedCountResponse;

public class FeedCount {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.ApiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.UserId = "remy.rey@rocket-internet.com";
        SellerCenter.Url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Call the API
         */
        FeedCountResponse res = Feeds.feedCount();

        /**
         * Pretty print the response
         */
        System.out.println("FeedCount :");

        com.sellercenter.api.models.Feed.FeedCount feedCount = res.getFeedCount();
        System.out.println("    Total       " + feedCount.getTotal());
        System.out.println("    Queued      " + feedCount.getQueued());
        System.out.println("    Processing  " + feedCount.getProcessing());
        System.out.println("    Finished    " + feedCount.getFinished());
        System.out.println("    Canceled    " + feedCount.getCanceled());
        System.out.println();
    }
}
