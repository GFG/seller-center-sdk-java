package com.sellercenter.api.endpoints.feed;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.models.Feed.FeedCount;

import java.util.Map;

public class FeedCountResponse extends ConcreteResponse {

    private final FeedCount feedCount;

    /**
     * @inheritDoc
     */
    public FeedCountResponse(SuccessResponse response) {
        super(response);
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
