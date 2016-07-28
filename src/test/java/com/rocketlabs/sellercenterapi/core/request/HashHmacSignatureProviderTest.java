package com.rocketlabs.sellercenterapi.core.request;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class HashHmacSignatureProviderTest extends TestCase {

    public void testSign() throws Exception {
        /**
         * TEST PARAMS
         *
         *  API key : b1bdb357ced10fe4e9a69840cdd4f0e9c03d77fe
         *
         *  Action=FeedList
         *  Format=XML
         *  Timestamp=2015-07-01T11:11:11+00:00
         *  UserID=look@me.com
         *  version=1.0
         *  Signature=9cbcdf6a7d8f8229ec01f67268a1ed82b47f8f931a2990316fe83835441ebff3
         */

        HashHmacSignatureProvider signer = new HashHmacSignatureProvider("b1bdb357ced10fe4e9a69840cdd4f0e9c03d77fe");
        Map<String, String> params = new HashMap<>();

        params.put("Action", "FeedList");
        params.put("Format", "XML");
        params.put("Timestamp", "2015-07-01T11:11:11+00:00");
        params.put("UserID", "look@me.com");
        params.put("version", "1.0");

        Assert.assertEquals(
                "9cbcdf6a7d8f8229ec01f67268a1ed82b47f8f931a2990316fe83835441ebff3",
                signer.sign(params)
        );
    }
}