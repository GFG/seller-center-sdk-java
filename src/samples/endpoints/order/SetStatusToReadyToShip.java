package endpoints.order;

import com.sellercenter.api.endpoints.OrderItemList;
import com.sellercenter.api.endpoints.SellerCenter;

import java.util.LinkedList;
import java.util.List;

public class SetStatusToReadyToShip {

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
        List<String> list = new LinkedList<String>();
        list.add("17340");
        list.add("17341");
        new OrderItemList(list).setStatusToReadyToShip();

        /**
         * Pretty print the response
         */
        System.out.println("Success !\n");
    }
}
