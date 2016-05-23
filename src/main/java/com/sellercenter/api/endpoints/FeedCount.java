package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.response.SuccessResponse;

public final class FeedCount extends AbstractModel {

    FeedCount(SuccessResponse response) {
        super(response);
        this.data = response.getObjectFromBody("FeedCount");
    }

    public int getFinished () {
        return getInt("Finished");
    };

    public int getTotal () {
        return getInt("Total");
    };

    public int getQueued () {
        return getInt("Queued");
    };

    public int getCanceled () {
        return getInt("Canceled");
    };

    public int getProcessing () {
        return getInt("Processing");
    };

}
