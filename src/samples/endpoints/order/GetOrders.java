package endpoints.order;

import com.sellercenter.api.endpoints.GetOrdersOptions;
import com.sellercenter.api.endpoints.Order;
import com.sellercenter.api.endpoints.OrderList;
import com.sellercenter.api.endpoints.SellerCenter;

public class GetOrders {
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
        GetOrdersOptions opt = (new GetOrdersOptions()).setLimit(5);
        OrderList res = SellerCenter.getOrders(opt);

        /**
         * Pretty print the response
         */
        System.out.println("Success :");

        System.out.println();
        System.out.println("Orders:");
        System.out.println();
        for (Order order : res) {
            System.out.println("    Order :");
            System.out.println("    |   id    : " + order.getOrderId());
            System.out.println("    |   price : " + order.getPrice());
            System.out.println("    |   items : " + order.getItemsCount());
            System.out.println();
        }
    }
}
