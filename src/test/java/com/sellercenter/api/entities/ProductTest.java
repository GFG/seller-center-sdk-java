package com.sellercenter.api.entities;

import junit.framework.TestCase;
import org.junit.Assert;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class ProductTest extends TestCase {

    public void testConstructor() {
        String data = "{\n" +
                "          \"Integer\": \"57335\",\n" +
                "          \"Float\": \"57.335\",\n" +
                "          \"String\": \"http://alice-lazada-th.sellercenter.net//109219.html\",\n" +
                "          \"Images\": {\n" +
                "            \"Image\": [\n" +
                "              \"img1\",\n" +
                "              \"img2\"\n" +
                "            ]\n" +
                "          },\n" +
                "          \"ProductData\": {}\n" +
                "        }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();

        Product product = new Product(json);

        Assert.assertTrue(product.getImages().contains("img1"));
        Assert.assertTrue(product.getImages().contains("img2"));

    }

    public void testImages() {
        String data = "{\n" +
                "          \"Integer\": \"57335\",\n" +
                "          \"Float\": \"57.335\",\n" +
                "          \"String\": \"http://alice-lazada-th.sellercenter.net//109219.html\",\n" +
                "          \"Images\": {\n" +
                "            \"Image\": [\n" +
                "              \"img1\",\n" +
                "              \"img2\"\n" +
                "            ]\n" +
                "          },\n" +
                "          \"ProductData\": {}\n" +
                "        }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();

        Product product = new Product(json);

        Assert.assertTrue(product.getImages().contains("img1"));
        Assert.assertTrue(product.getImages().contains("img2"));
    }
}
