package endpoints.order;

import com.sellercenter.api.endpoints.Order;
import com.sellercenter.api.endpoints.OrderItem;
import com.sellercenter.api.endpoints.OrderItemList;
import com.sellercenter.api.endpoints.SellerCenter;

public class GetOrderItems {
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
        OrderItemList list = new Order("22463").getItems();

        /**
         * Pretty print the response
         */
        System.out.println("Success !");

        System.out.println();
        System.out.println("Order Items :");
        System.out.println();
        for (OrderItem item : list) {
            System.out.println("    Item:");
            System.out.println("    |   Id:     " + item.getId());
            System.out.println("    |   Name:   " + item.getName());
            System.out.println("    |   Status: " + item.getStatus());
            System.out.println();
        }
    }
}
