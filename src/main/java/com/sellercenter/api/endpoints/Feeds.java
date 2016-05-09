package com.sellercenter.api.endpoints;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.endpoints.feed.FeedCountRequest;
import com.sellercenter.api.endpoints.feed.FeedCountResponse;
import com.sellercenter.api.exceptions.*;

public class Feeds extends SellerCenter{

    /**
     * Performs a FeedCount request
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
    public static FeedCountResponse feedCount()
            throws SdkException, ApiException, RateLimitException, AuthenticationException, InvalidRequestException, ResourceNotFoundException {

        SuccessResponse res = Client.call(new FeedCountRequest(getUserId(), getApiKey(), getVersion()), getUrl());
        return new FeedCountResponse(res);
    }
}
