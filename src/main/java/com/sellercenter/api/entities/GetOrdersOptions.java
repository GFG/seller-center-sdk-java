package com.sellercenter.api.entities;

import com.sellercenter.api.core.request.TimestampFormatter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class GetOrdersOptions {
    private static final int DEFAULT_OFFSET = 0;
    private static final int DEFAULT_LIMIT = 100;

    private Date createdAfter;
    private Date createdBefore;
    private int offset = DEFAULT_OFFSET;
    private int limit = DEFAULT_LIMIT;
    private String status;

    private TimestampFormatter time = new TimestampFormatter();

    /**
     * Limits the returned product list to those created after or on a specified date
     *
     * @param createdAfter the specified date
     * @return the calling instance for chaining.
     */
    public GetOrdersOptions setCreatedAfter(Date createdAfter) {
        this.createdAfter = createdAfter;
        return this;
    }

    /**
     * Limits the returned product list to those created before or on a specified date
     *
     * @param createdBefore the specified date
     * @return the calling instance for chaining.
     */
    public GetOrdersOptions setCreatedBefore(Date createdBefore) {
        this.createdBefore = createdBefore;
        return this;
    }

    /**
     * The maximum number of products that should be returned.
     * If you omit this parameter, the default of 1000 is used
     *
     * @param limit positive integer, 1000 by default
     * @return the calling instance for chaining.
     */
    public GetOrdersOptions setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Number of products to skip. Useful for pagination.
     *
     * @param offset positive integer
     * @return the calling instance for chaining.
     */
    public GetOrdersOptions setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Limits the returned set of orders to return only entries which fit the status provided.
     *
     * @param status Possible values are pending, canceled, ready_to_ship, delivered, returned, shipped and failed
     */
    public GetOrdersOptions setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Build a map representing the optional parameters of the request.
     * All parameters are formatted to the API requirement.
     *
     * @return map of optional parameters
     */
    Map<String, String> toMap() {

        HashMap<String, String> map = new HashMap<>();
        if (status != null) {
            map.put("Status", status);
        }
        if (createdAfter != null) {
            map.put("CreatedAt", time.getTimestamp(createdAfter));
        }
        if (createdBefore != null) {
            map.put("CreatedBefore", time.getTimestamp(createdBefore));
        }
        if (limit >= 0) {
            if(offset >= 0) {
                map.put("Offset", Integer.toString(offset));
            }
            map.put("Limit", Integer.toString(limit));
        }
        return map;
    }
}
