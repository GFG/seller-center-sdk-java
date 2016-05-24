package com.sellercenter.api.endpoints.products;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class GetProductsRequestTest extends TestCase {

    public void testParamsWithOpt() throws SdkException {
        LinkedList<String> skuList = new LinkedList<String>();
        skuList.add("hello");
        skuList.add("world");
        skuList.add("!!!");

        GetProductsOptions otp = (new GetProductsOptions())
                .setCreatedAfter(new Date())
                .setCreatedBefore(new Date())
                .setFilter("filter")
                .setOffset(3)
                .setLimit(5)
                .setSkuList(skuList)
                .setGlobalIdentifier(true)
                .setSearch("search");

        GetProductsRequest req = new GetProductsRequest("UserId", "key", "version", otp);
        Map<String, String> params = req.getParams();

        Assert.assertEquals("filter", params.get("Filter"));
        Assert.assertEquals("3", params.get("Offset"));
        Assert.assertEquals("5", params.get("Limit"));
        Assert.assertEquals("[\"hello\",\"world\",\"!!!\"]", params.get("SkuSellerList"));
        Assert.assertEquals("search", params.get("Search"));
        Assert.assertEquals("1", params.get("GlobalIdentifier"));


    }

    public void testParams() throws SdkException {
        GetProductsRequest req = new GetProductsRequest("UserId", "key", "version");
        Map<String, String> params = req.getParams();

        Assert.assertEquals("GetProducts", params.get("Action"));
    }
}