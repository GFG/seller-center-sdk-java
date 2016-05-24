package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.*;

public class GetOrderItemsRequestTest extends TestCase {

    public void testParams() throws SdkException {
        GetOrderItemsRequest req = new GetOrderItemsRequest("id", "key", "version", 1);
        Map<String, String> params = req.getParams();

        Assert.assertEquals("GetOrderItems", params.get("Action"));
        Assert.assertEquals("1", params.get("OrderId"));
    }
}