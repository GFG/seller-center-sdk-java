package com.sellercenter.api.core.request;

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
         *  Version=1.0
         *  Signature=3ceb8ed91049dfc718b0d2d176fb2ed0e5fd74f76c5971f34cdab48412476041
         */

        HashHmacSignatureProvider signer = new HashHmacSignatureProvider("b1bdb357ced10fe4e9a69840cdd4f0e9c03d77fe");
        Map<String, String> params = new HashMap<String, String>();

        params.put("Action", "FeedList");
        params.put("Format", "XML");
        params.put("Timestamp", "2015-07-01T11:11:11+00:00");
        params.put("UserID", "look@me.com");
        params.put("Version", "1.0");

        Assert.assertEquals(
                "3ceb8ed91049dfc718b0d2d176fb2ed0e5fd74f76c5971f34cdab48412476041",
                signer.sign(params)
        );
    }
}