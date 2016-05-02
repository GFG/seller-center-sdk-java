package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostTest extends TestCase {

    public void testGetParams() throws SdkException {

        Map<String,String> params = new HashMap<String, String>();
        Map<String,Object> body = new HashMap<String, Object>();

        HashHmacSignatureProvider signatureProviderMock = mock(HashHmacSignatureProvider.class);
        when(signatureProviderMock.sign(params)).thenReturn("3ceb8ed91049dfc718b0d2d176fb2ed0e5fd74f76c5971f34cdab48412476041");
        Post request = new Post(body, params, signatureProviderMock, mock(TimestampFormatter.class));

        Map<String, String> result = request.getParams();
        Assert.assertEquals("3ceb8ed91049dfc718b0d2d176fb2ed0e5fd74f76c5971f34cdab48412476041", result.get("Signature"));
    }

    public void testGetMethod() throws Exception {
        Post request = new Post(
                new HashMap<String, Object>(),
                new HashMap<String, String>(),
                mock(HashHmacSignatureProvider.class),
                mock(TimestampFormatter.class)
        );
        Assert.assertEquals(Request.POST, request.getMethod());
    }
}