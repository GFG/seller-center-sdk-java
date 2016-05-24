package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetTest extends TestCase {

    public void testGetParams() throws SdkException {
        Map<String,String> params = new HashMap<String, String>();
        Map<String,Object> body = new HashMap<String, Object>();

        HashHmacSignatureProvider signatureProviderMock = mock(HashHmacSignatureProvider.class);
        when(signatureProviderMock.sign(params)).thenReturn("3ceb8ed91049dfc718b0d2d176fb2ed0e5fd74f76c5971f34cdab48412476041");

        TimestampFormatter time =  mock(TimestampFormatter.class);
        when(time.getTimestamp(null)).thenReturn("");

        Get request = new Get(body, params, signatureProviderMock, time);

        Map<String, String> result = request.getParams();
        Assert.assertEquals("3ceb8ed91049dfc718b0d2d176fb2ed0e5fd74f76c5971f34cdab48412476041", result.get("Signature"));
    }

    public void testGetMethod() throws Exception {
        Get request = new Get(
                new HashMap<String, Object>(),
                new HashMap<String, String>(),
                mock(SignatureProvider.class),
                mock(TimestampFormatter.class)
        );
        Assert.assertEquals(Request.GET, request.getMethod());
    }
}