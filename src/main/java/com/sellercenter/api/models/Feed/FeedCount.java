package com.sellercenter.api.models.Feed;

import com.sellercenter.api.core.response.AbstractModel;

import java.util.Map;

public class FeedCount extends AbstractModel {

    public FeedCount(Map<String, Object> data) {
        super(data);
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
