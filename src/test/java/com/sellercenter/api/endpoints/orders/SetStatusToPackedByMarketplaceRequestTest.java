package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SetStatusToPackedByMarketplaceRequestTest extends TestCase {

    public void testParams() throws SdkException {
        List<Integer> orderItemIds = new LinkedList<Integer>();
        orderItemIds.add(1);
        orderItemIds.add(2);
        SetStatusToPackedByMarketplaceRequest req = new SetStatusToPackedByMarketplaceRequest(
                "id", "key", "version", orderItemIds, "delivery type", "shipping provider"
        );
        Map<String, String> params = req.getParams();

        Assert.assertEquals("SetStatusToPackedByMarketplace", params.get("Action"));
        Assert.assertEquals("delivery type", params.get("DeliveryType"));
        Assert.assertEquals("shipping provider", params.get("ShippingProvider"));
        Assert.assertEquals("[1,2]", params.get("OrderItemIds"));
    }
}