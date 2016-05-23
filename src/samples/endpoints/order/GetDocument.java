package endpoints.order;

import com.sellercenter.api.endpoints.OrderItemList;
import com.sellercenter.api.endpoints.SellerCenter;

import java.util.LinkedList;
import java.util.List;

public class GetDocument {

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
        List<String> ids = new LinkedList<String>();
        ids.add("17340");
        ids.add("17341");
        new OrderItemList(ids).getDocument("shippingParcel");

    }
}
