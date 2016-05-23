package endpoints.order;

import com.sellercenter.api.endpoints.SellerCenter;
import com.sellercenter.api.endpoints.Order;

public class GetOrder {
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
        Order order = new Order("39342").retrieve();


        /**
         * Pretty print the response
         */
        System.out.println("Success !");

        System.out.println();
        System.out.println("Order :");
        System.out.println("|   id    : " + order.getOrderId());
        System.out.println("|   price : " + order.getPrice());
        System.out.println("|   items : " + order.getItemsCount());
    }
}
