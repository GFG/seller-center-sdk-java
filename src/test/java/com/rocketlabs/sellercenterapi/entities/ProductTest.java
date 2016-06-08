package com.rocketlabs.sellercenterapi.entities;

import junit.framework.TestCase;
import org.junit.Assert;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class ProductTest extends TestCase {

    public void testBuildClean() {
        String data = "{" +
                "          \"Images\": {" +
                "            \"Image\": [" +
                "              \"img1\"," +
                "              \"img2\"" +
                "            ]" +
                "          }," +
                "          \"ProductData\": {}" +
                "        }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();

        Product product = new Product(json);
    }

    public void testBuildWithoutData() {
        String data = "{}";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();

        Product product = new Product(json);
        Assert.assertNotNull(product.getImages());
        Assert.assertNotNull(product.getProductData());
    }

    public void testImages() {
        String data = "{" +
                "          \"Images\": {" +
                "            \"Image\": [" +
                "              \"img1\"," +
                "              \"img2\"" +
                "            ]" +
                "          }" +
                "        }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();

        Product product = new Product(json);

        Assert.assertTrue(product.getImages().contains("img1"));
        Assert.assertTrue(product.getImages().contains("img2"));
        Assert.assertEquals(new Integer(2), new Integer(product.getImages().size()));
    }
}
