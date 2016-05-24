package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Date;
import java.util.Map;

public class GetOrdersRequestTest extends TestCase {

    public void testParams() throws SdkException {
        GetOrdersOptions opt = (new GetOrdersOptions())
                .setCreatedAfter(new Date())
                .setCreatedBefore(new Date())
                .setLimit(2)
                .setOffset(3)
                .setStatus("hello");

        GetOrdersRequest req = new GetOrdersRequest("id", "key", "version", opt);
        Map<String, String> params = req.getParams();

        Assert.assertEquals("GetOrders", params.get("Action"));
        Assert.assertEquals("2", params.get("Limit"));
        Assert.assertEquals("3", params.get("Offset"));
        Assert.assertEquals("hello", params.get("Status"));
    }
}