package com.sellercenter.api.endpoints.feed;

import com.sellercenter.api.core.request.Get;

public class FeedCountRequest extends Get{

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param secretKey the API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     */
    public FeedCountRequest(String userId, String secretKey, String version) {
        super(userId, secretKey, version);
        this.addParam("Action", "FeedCount");
    }
}
