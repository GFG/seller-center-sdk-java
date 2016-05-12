package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GetDocumentRequestTest extends TestCase {

    public void testParams () throws SdkException {
        List<Integer> itemIdList = new LinkedList<Integer>();
        itemIdList.add(1);
        itemIdList.add(2);
        GetDocumentRequest req = new GetDocumentRequest("UserId", "key", "version", "doc type", itemIdList);

        Map<String, String> params = req.getParams();

        Assert.assertEquals("GetDocument", params.get("Action"));
        Assert.assertEquals("doc type", params.get("DocumentType"));
        Assert.assertEquals("[1,2]", params.get("OrderItemIds"));
    }

}