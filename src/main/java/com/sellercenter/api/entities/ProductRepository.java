package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import java.util.HashMap;
import java.util.Map;

class ProductRepository {

    /**
     * Save one product to Seller Center
     *
     * @param product product to be persisted
     * @throws SdkException
     */
    void persist(Product product) throws SdkException {
        String action;
        if (product.isNew()) {
            action = "ProductCreate";
        } else {
            action = "ProductUpdate";
        }

        Map<String, String> p = new HashMap<>();

        Client.call(
                new Request(action, SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, p, product.toMap())
        );
    }

    /**
     * Save all products to Seller Center
     *
     * @param products List of products to be persisted
     * @throws SdkException
     */
    void persist(ProductList products) throws SdkException {
        Map<String, String> p = new HashMap<>();
        // @todo: check for create/update
        Client.call(
                new Request("ProductUpdate", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, p, products.toMap())
        );
    }

    /**
     * Perform api call to get a list of products
     * under the options constraint
     *
     * @param options optional request parameters
     * @return list of all or a range of products
     * @throws SdkException
     */
    ProductList retrieve(GetProductsOptions options) throws SdkException {
        SuccessResponse response = Client.call(
                new Request("GetProducts", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, options.toMap())
        );

        return new ProductList(response);
    }
}
