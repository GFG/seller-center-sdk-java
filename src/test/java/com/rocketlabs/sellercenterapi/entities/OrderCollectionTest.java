package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;
import com.rocketlabs.sellercenterapi.exceptions.ResponseDataException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.mockito.Mockito;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class OrderCollectionTest extends TestCase {

    public void testBuildEmpty() {
        String data = "{" +
                "      \"Orders\": \"\"" +
                "    }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);

        try {
            OrderCollection orders = new OrderCollection(res);
            Assert.assertEquals(0, orders.getIds().size());
        } catch (ResponseDataException e) {
            e.printStackTrace();
        }
    }


    public void testBuildSingle() {
        String data = "{\n" +
                "      \"Orders\": {\n" +
                "        \"Order\": {\n" +
                "          \"OrderId\": \"14272\"\n" +
                "        }\n" +
                "      }\n" +
                "    }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);

        try {
            OrderCollection orders = new OrderCollection(res);
            Assert.assertEquals(1, orders.getIds().size());
        } catch (ResponseDataException e) {
            e.printStackTrace();
        }
    }

    public void testBuildMultiple() {
        String data = "{\n" +
                "      \"Orders\": {\n" +
                "        \"Order\": [\n" +
                "          {\n" +
                "            \"OrderId\": \"363\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"OrderId\": \"929\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"OrderId\": \"999\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"OrderId\": \"14269\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }";

        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);

        try {
            OrderCollection orders = new OrderCollection(res);
            Assert.assertEquals(4, orders.getIds().size());
        } catch (ResponseDataException e) {
            e.printStackTrace();
        }
    }

    public void testFailBuildNoData() {
        String data = "{" +
                "    }";

        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);

        try {
            OrderCollection orders = new OrderCollection(res);
            fail();
        } catch (ResponseDataException e) {
            // expected
        }
    }

    public void testFailBuildNoOrder() {
        String data = "{" +
                "      \"Orders\": {}" +
                "    }";

        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        Mockito.when(res.getBody()).thenReturn(json);

        try {
            OrderCollection orders = new OrderCollection(res);
            fail();
        } catch (ResponseDataException e) {
            // expected
        }
    }
}
