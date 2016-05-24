package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.*;

public class GetOrderRequestTest extends TestCase {

    public void testParams() throws SdkException {
        GetOrderRequest req = new GetOrderRequest("userId", "key", "1.0", 3);

        Assert.assertEquals("3", req.getParams().get("OrderId"));
        Assert.assertEquals("GetOrder", req.getParams().get("Action"));
    }
}