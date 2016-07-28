package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;
import junit.framework.TestCase;
import org.junit.Assert;
import org.mockito.Mockito;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class OrderItemCollectionTest extends TestCase {

    public void testBuildSingleOrder() {
        String data = "{" +
                "      \"OrderItems\": {" +
                "        \"OrderItem\": {" +
                "          \"OrderItemId\": \"15473\"," +
                "          \"ShopId\": \"503828\"," +
                "          \"OrderId\": \"363\"," +
                "          \"Name\": \"Brownie Set\"" +
                "        }" +
                "      }" +
                "    }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);
        OrderItemCollection collection = null;
        try {
            collection = new OrderItemCollection(res);
        } catch (SdkException e) {
            fail();
        }
        Assert.assertEquals(1, collection.getIds().size());
    }

    public void testBuildMultipleOrders() {
        String data = "{" +
                "      \"Orders\": {" +
                "        \"Order\": [" +
                "          {" +
                "            \"OrderId\": \"929\"," +
                "            \"OrderItems\": {" +
                "              \"OrderItem\": {" +
                "                \"OrderItemId\": \"15472\"," +
                "                \"Name\": \"Brown Love Dress\"" +
                "              }" +
                "            }" +
                "          }," +
                "          {" +
                "            \"OrderId\": \"363\"," +
                "            \"OrderItems\": {" +
                "              \"OrderItem\": {" +
                "                \"OrderItemId\": \"15473\"," +
                "                \"Name\": \"Brownie Set\"" +
                "              }" +
                "            }" +
                "          }" +
                "        ]" +
                "      }" +
                "    }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);
        OrderItemCollection collection = null;
        try {
            collection = new OrderItemCollection(res);
        } catch (SdkException e) {
            fail();
        }
        Assert.assertEquals(2, collection.getIds().size());
    }

    public void testBuildMultipleItems() {
        String data = "{" +
                "      \"OrderItems\": {" +
                "        \"OrderItem\": [" +
                "          {" +
                "            \"OrderItemId\": \"91616\"," +
                "            \"Name\": \"Vodka can\"" +
                "          }," +
                "          {" +
                "            \"OrderItemId\": \"91617\"," +
                "            \"Name\": \"Double Fried Chicken\"" +
                "          }," +
                "          {" +
                "            \"OrderItemId\": \"91618\"," +
                "            \"Name\": \"Frozen Pizza\"" +
                "          }," +
                "          {" +
                "            \"OrderItemId\": \"91620\"," +
                "            \"Name\": \"Peanut butter jelly\"" +
                "          }" +
                "        ]" +
                "      }" +
                "    }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);
        OrderItemCollection collection = null;
        try {
            collection = new OrderItemCollection(res);
        } catch (SdkException e) {
            fail();
        }
        Assert.assertEquals(4, collection.getIds().size());
    }
}
