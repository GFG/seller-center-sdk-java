package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.ResponseDataException;
import junit.framework.TestCase;
import org.mockito.Mockito;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class ProductCollectionTest extends TestCase {

    public void testBuildArray() throws ResponseDataException {
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        String data = "{" +
                "  \"SuccessResponse\": {" +
                "    \"Body\": {" +
                "      \"Products\": {" +
                "        \"Product\": [" +
                "          {" +
                "            \"SellerSku\": \"sku1\"" +
                "          }," +
                "          {" +
                "            \"SellerSku\": \"sku2\"" +
                "          }" +
                "        ]" +
                "      }" +
                "    }" +
                "  }" +
                "}";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        Mockito.when(res.getBody()).thenReturn(json.getJsonObject("SuccessResponse").getJsonObject("Body"));

        new ProductCollection(res);
    }

    public void testBuildObject() throws ResponseDataException {
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        String data = "{" +
                "  \"SuccessResponse\": {" +
                "    \"Body\": {" +
                "      \"Products\": {" +
                "        \"Product\":" +
                "          {" +
                "            \"SellerSku\": \"DR71-7-1\"," +
                "            \"Images\": \"\"," +
                "            \"ProductData\": {" +
                "            }" +
                "          }" +
                "      }" +
                "    }" +
                "  }" +
                "}";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        Mockito.when(res.getBody()).thenReturn(json.getJsonObject("SuccessResponse").getJsonObject("Body"));

        new ProductCollection(res);
    }

    public void testBuildEmpty() throws ResponseDataException {
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        String data = "{" +
                "  \"SuccessResponse\": {" +
                "    \"Head\": {" +
                "    }," +
                "    \"Body\": {" +
                "      \"Products\": \"\"" +
                "    }" +
                "  }" +
                "}";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        Mockito.when(res.getBody()).thenReturn(json.getJsonObject("SuccessResponse").getJsonObject("Body"));

        new ProductCollection(res);
    }

    public void testFailBuildNoProducts() throws ResponseDataException {
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        String data = "{" +
                "  \"SuccessResponse\": {" +
                "    \"Head\": {" +
                "    }," +
                "    \"Body\": {" +
                "    }" +
                "  }" +
                "}";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        Mockito.when(res.getBody()).thenReturn(json.getJsonObject("SuccessResponse").getJsonObject("Body"));
        try {
            new ProductCollection(res);
            fail();
        } catch (ResponseDataException e) {
            // expected
        }
    }

    public void testFailBuildNoProduct() throws ResponseDataException {
        SuccessResponse res = Mockito.mock(SuccessResponse.class);
        String data = "{" +
                "  \"SuccessResponse\": {" +
                "    \"Head\": {" +
                "    }," +
                "    \"Body\": {" +
                "      \"Products\": {}" +
                "    }" +
                "  }" +
                "}";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        Mockito.when(res.getBody()).thenReturn(json.getJsonObject("SuccessResponse").getJsonObject("Body"));
        try {
            new ProductCollection(res);
            fail();
        } catch (ResponseDataException e) {
            // expected
        }
    }
}
