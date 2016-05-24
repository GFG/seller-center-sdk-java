package endpoints.order;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.endpoints.Orders;
import com.sellercenter.api.endpoints.orders.GetOrderItemsResponse;
import com.sellercenter.api.models.Order.OrderItem;

public class GetOrderItems {
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
        GetOrderItemsResponse res = Orders.getOrderItems(22463);

        /**
         * Pretty print the response
         */
        System.out.println("Success :");
        System.out.println(">   " + res.getResponseType());
        System.out.println(">   " + res.getTimestamp());

        System.out.println();
        System.out.println("Order Items :");
        System.out.println();
        for (OrderItem item : res.getItemList()) {
            System.out.println("    Item:");
            System.out.println("    |   Id:     " + item.getOrderItemId());
            System.out.println("    |   Name:   " + item.getName());
            System.out.println("    |   Status: " + item.getStatus());
            System.out.println();
        }
    }
}
