package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SetStatusToReadyToShipRequestTest extends TestCase{

    public void testParams() throws SdkException {
        List<Integer> orderItemIds = new LinkedList<Integer>();
        orderItemIds.add(1);
        orderItemIds.add(2);
        SetStatusToReadyToShipRequest req = new SetStatusToReadyToShipRequest(
                "id", "key", "version", orderItemIds, "delivery type", "shipping provider", 123456789
        );
        Map<String, String> params = req.getParams();

        Assert.assertEquals("SetStatusToReadyToShip", params.get("Action"));
        Assert.assertEquals("delivery type", params.get("DeliveryType"));
        Assert.assertEquals("shipping provider", params.get("ShippingProvider"));
        Assert.assertEquals("[1,2]", params.get("OrderItemIds"));
        Assert.assertEquals("123456789", params.get("TrackingNumber"));
    }

}