package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

public final class FeedCount extends AbstractModel {

    /**
     * Constructor
     *
     * @param response response from API
     */
    FeedCount(SuccessResponse response) {
        super(response.getBody().getJsonObject("FeedCount"));
    }
}
