package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.request.TimestampFormatter;
import com.sellercenter.api.core.utils.Helper;

import java.util.*;

public final class GetProductsOptions {
    private static final int DEFAULT_OFFSET = 0;
    private static final int DEFAULT_LIMIT = 1000;

    private Date createdAfter = null;
    private Date CreatedBefore = null;
    private Date UpdatedAfter = null;
    private Date UpdatedBefore = null;
    private String search = null;
    private String filter = null;
    private List<String> skuList = new ArrayList<String>();
    private int offset = DEFAULT_OFFSET;
    private int limit = DEFAULT_LIMIT;
    private boolean globalIdentifier = false;

    private TimestampFormatter time = new TimestampFormatter();

    /**
     * Limits the returned product list to those created after or on a specified date
     *
     * @param createdAfter the specified date
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setCreatedAfter(Date createdAfter) {
        this.createdAfter = createdAfter;
        return this;
    }

    /**
     * Limits the returned product list to those created before or on a specified date
     *
     * @param createdBefore the specified date
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setCreatedBefore(Date createdBefore) {
        CreatedBefore = createdBefore;
        return this;
    }

    /**
     * Return only those products whose state matches this parameter.
     *
     * @param filter Possible values are all, live, inactive, deleted, image-missing, pending, rejected, sold-out
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setFilter(String filter) {
        this.filter = filter;
        return this;
    }

    public boolean isGlobalIdentifier() {
        return globalIdentifier;
    }

    /**
     * If set to true, Brand, PrimaryCategory, Categories and all Attributes in ProductData
     * will be returned with Global Identifiers
     *
     * @param globalIdentifier boolean, false by default
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setGlobalIdentifier(boolean globalIdentifier) {
        this.globalIdentifier = globalIdentifier;
        return this;
    }

    /**
     * The maximum number of products that should be returned.
     * If you omit this parameter, the default of 1000 is used
     *
     * @param limit positive integer, 1000 by default
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Number of products to skip. Useful for pagination.
     *
     * @param offset positive integer
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Limits to those products where the search string is contained in the product's name and/or SKU.
     *
     * @param search string to filter
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setSearch(String search) {
        this.search = search;
        return this;
    }

    /**
     * Limits to products whose SKU is contained in the specified list
     *
     * @param skuList list of searched sku
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setSkuList(List<String> skuList) {
        this.skuList = skuList;
        return this;
    }

    /**
     * Limits to products whose SKU are added
     *
     * @param sku one of the searched sku
     * @return the calling instance for chaining.
     */
    public GetProductsOptions addSku(String sku) {
        this.skuList.add(sku);
        return this;
    }

    /**
     * Limits the returned product list to those updated after or on a specified date
     *
     * @param updatedAfter the specified date
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setUpdatedAfter(Date updatedAfter) {
        UpdatedAfter = updatedAfter;
        return this;
    }

    /**
     * Limits the returned product list to those updated before or on a specified date
     *
     * @param updatedBefore the specified date
     * @return the calling instance for chaining.
     */
    public GetProductsOptions setUpdatedBefore(Date updatedBefore) {
        UpdatedBefore = updatedBefore;
        return this;
    }

    /**
     * Build a map representing the optional parameters of the request.
     * All parameters are formatted to the API requirement.
     *
     * @return map of optionnal parameters
     */
    Map<String,String> toMap() {

        HashMap<String, String> map = new HashMap<String, String>();
        if (globalIdentifier) {
            map.put("GlobalIdentifier", "1");
        }
        if (createdAfter != null) {
            map.put("CreatedAt", this.time.getTimestamp(createdAfter));
        }
        if (CreatedBefore != null) {
            map.put("CreatedBefore", this.time.getTimestamp(CreatedBefore));
        }
        if (UpdatedAfter != null) {
            map.put("UpdatedAfter", this.time.getTimestamp(UpdatedAfter));
        }
        if (UpdatedBefore != null) {
            map.put("UpdatedBefore", this.time.getTimestamp(UpdatedBefore));
        }
        if (search != null) {
            map.put("Search", search);
        }
        if (filter != null) {
            map.put("Filter", filter);
        }
        if (!skuList.isEmpty()) {
            map.put("SkuSellerList", Helper.toParam(skuList));
        }
        if (offset != DEFAULT_OFFSET) {
            map.put("Offset", Integer.toString(offset));
        }
        if (limit != DEFAULT_LIMIT) {
            map.put("Limit", Integer.toString(limit));
        }
        return map;
    }
}
