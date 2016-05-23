package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

public final class SellerCenter {

    /**
     * The URL of the Seller Center API
     */
    public static String url;

    /**
     * The API key of the User
     */
    public static String apiKey;

    /**
     * The ID of the User
     */
    public static String userId;

    /**
     * The version of the API
     */
    public static String version = "1.0";

    /**
     *
     * @param options optional request parameters
     * @return list of the customer details for a range of orders
     * @throws SdkException
     */
    public static OrderList getOrders(GetOrdersOptions options) throws SdkException {
        SuccessResponse response = Client.call(
                new Request("GetOrders", userId, apiKey, version, options.toMap())
        );
        return new OrderList(response);
    }

    /**
     *
     * @return feed statistics
     * @throws SdkException
     */
    public static FeedCount feedCount() throws SdkException {
        SuccessResponse response = Client.call(
                new Request("FeedCount", userId, apiKey, version)
        );

        return new FeedCount(response);
    }

    /**
     *
     * @param options optional request parameters
     * @return list of all or a range of products
     * @throws SdkException
     */
    public static ProductList getProducts(GetProductsOptions options) throws SdkException {
        SuccessResponse response = Client.call(
                new Request("GetProducts", userId, apiKey, version),
                url
        );

        return new ProductList(response);
    }
}
