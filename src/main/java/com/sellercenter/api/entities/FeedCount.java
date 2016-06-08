package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;

public final class FeedCount extends AbstractModel {

    /**
     * Constructor
     *
     * @param response response from API
     */
    FeedCount(SuccessResponse response) {
        super(response.getBody().getJsonObject("FeedCount"));
    }

    public int getFinished() {
        return getInt("Finished");
    }

    public int getTotal() {
        return getInt("Total");
    }

    public int getQueued() {
        return getInt("Queued");
    }

    public int getCanceled() {
        return getInt("Canceled");
    }

    public int getProcessing() {
        return getInt("Processing");
    }

}
