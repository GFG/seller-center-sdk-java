package com.sellercenter.api.endpoints.feed;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Feed.FeedCount;

import java.util.Map;

public class FeedCountResponse extends SuccessResponse {

    private final FeedCount feedCount;

    /**
     * Constructor
     *
     * @param response the successful response returned by the client
     */
    public FeedCountResponse(SuccessResponse response) {
        super(response.getRequestAction(), response.getResponseType(), response.getTimestamp(), response.getBody());
        this.feedCount = new FeedCount((Map<String, Object>) getBody().get("FeedCount"));
    }

    /**
     * getter for FeedCount
     *
     * @return FeedCount model
     */
    public FeedCount getFeedCount() {
        return feedCount;
    }
}
