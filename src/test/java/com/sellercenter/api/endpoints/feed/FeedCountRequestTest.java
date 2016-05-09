package com.sellercenter.api.endpoints.feed;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.*;

public class FeedCountRequestTest extends TestCase {

    public void testParams() throws SdkException {
        FeedCountRequest feedCountRequest = new FeedCountRequest("userId", "key", "1.0");

        Assert.assertEquals("FeedCount", feedCountRequest.getParams().get("Action"));

    }
}