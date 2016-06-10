package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

class ProductRepository {

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
