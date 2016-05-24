package endpoints.order;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.endpoints.Orders;
import com.sellercenter.api.endpoints.orders.GetOrderResponse;
import com.sellercenter.api.models.Order.Order;

public class GetOrder {
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
        GetOrderResponse res = Orders.getOrder(39342);

        /**
         * Pretty print the response
         */
        System.out.println("Success :");
        System.out.println(">   " + res.getResponseType());
        System.out.println(">   " + res.getTimestamp());

        Order order = res.getOrder();
        System.out.println();
        System.out.println("Order :");
        System.out.println("|   id    : " + order.getOrderId());
        System.out.println("|   price : " + order.getPrice());
        System.out.println("|   items : " + order.getItemsCount());
    }
}
