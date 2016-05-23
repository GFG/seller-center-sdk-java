package endpoints.order;

import com.sellercenter.api.endpoints.OrderItem;
import com.sellercenter.api.endpoints.SellerCenter;

public class SetStatusToCanceled {
    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.userId = "remy.rey@rocket-internet.com";
        SellerCenter.url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Perform the API call
         */
        new OrderItem("22475").setStatusToCanceled("Changed Mind", "reason+detail");

        /**
         * Pretty print the response
         */
        System.out.println("Success !");
    }
}
