package com.sellercenter.api.endpoints;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.endpoints.products.GetProductsOptions;
import com.sellercenter.api.endpoints.products.GetProductsRequest;
import com.sellercenter.api.endpoints.products.GetProductsResponse;
import com.sellercenter.api.exceptions.*;

public class Products extends SellerCenter {

    /**
     * Performs a GetProducts request
     *
     * @param opt optional parameters for the request :
     *            Limit, Offset,
     *            CreatedAt, CreatedBefore, UpdatedBefore, UpdatedAfter
     *            Filter, Search
     *            SkuList
     *
     * @return A specific success response
     *
     * @throws SdkException
     * @throws ApiException
     * @throws RateLimitException
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     */
    public static GetProductsResponse getProducts(GetProductsOptions opt)
            throws SdkException, ApiException, RateLimitException, AuthenticationException, InvalidRequestException, ResourceNotFoundException {

        SuccessResponse res = Client.call(new GetProductsRequest(getUserId(), getApiKey(), getVersion(), opt), getUrl());
        return new GetProductsResponse(res);
    }
}



