package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.*;

public class SetStatusToCanceledRequestTest extends TestCase {

    public void testParams() throws SdkException {
        SetStatusToCanceledRequest req = new SetStatusToCanceledRequest("userId", "key", "version", "3", "reason", "detail");
        Map<String, String> params =  req.getParams();

        Assert.assertEquals("SetStatusToCanceled", params.get("Action"));
        Assert.assertEquals("3", params.get("OrderId"));
        Assert.assertEquals("reason", params.get("Reason"));
        Assert.assertEquals("detail", params.get("ReasonDetail"));
    }
}