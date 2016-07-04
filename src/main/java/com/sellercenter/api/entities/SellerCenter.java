package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Interface responsible to gather generic calls (not related to a special entity)
 * and configuration (dynamic)
 */
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
     * Repository to fetch/save orders
     */
    private static final OrderRepository orderRepository = new OrderRepository();

    /**
     * Repository to fetch/save products
     */
    private static final ProductRepository productRepository = new ProductRepository();

    /**
     * Retrieve list of orders from repository
     *
     * @param options optional request parameters
     * @return list of the customer details for a range of orders
     * @throws SdkException
     */
    public static OrderList getOrders(GetOrdersOptions options) throws SdkException {
        return orderRepository.retrieve(options);
    }

    /**
     * Retrieve feed count data from Seller Center
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
     * Retrieve list of products from repository
     *
     * @param options optional request parameters
     * @return list of all or a range of products
     * @throws SdkException
     */
    public static ProductCollection getProducts(GetProductsOptions options) throws SdkException {
        return productRepository.retrieve(options);
    }

    /**
     *
     * @return
     * @throws SdkException
     */
    public static Collection<Category> getCategoryTree() throws SdkException {
        return productRepository.getCategoryTree();
    }

    /**
     *
     * @param products
     * @throws SdkException
     */
    public static void createProduct(List<Map> products) throws SdkException {
        productRepository.createProduct(products);
    }
}
