package endpoints.order;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.endpoints.Orders;
import com.sellercenter.api.endpoints.orders.SetStatusToCanceledResponse;

public class SetStatusToCanceled {
    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.ApiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.UserId = "remy.rey@rocket-internet.com";
        SellerCenter.Url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Perform the API call
         */
        SetStatusToCanceledResponse res = Orders.setStatusToCanceled(22475, "Changed%20mind", "reasondetail");

        /**
         * Pretty print the response
         */
        System.out.println("Success :");
        System.out.println(">   " + res.getResponseType());
        System.out.println(">   " + res.getTimestamp());
    }
}
