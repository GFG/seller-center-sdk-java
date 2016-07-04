package com.sellercenter.api.entities;

import junit.framework.TestCase;
import org.junit.Assert;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;


public class AbstractModelTest extends TestCase {

    public void testGetters() {

        String data = "{" +
                "          \"Integer\": \"1337\"," +
                "          \"Float\": \"13.37\"," +
                "          \"String\": \"String\"" +
                "        }";
        JsonObject json = Json.createReader(new StringReader(data)).readObject();
        AbstractModel model = new AbstractModel(json) {
        };

        Assert.assertEquals(new Integer(1337), model.getInt("Integer"));
        Assert.assertEquals(new Float(13.37), model.getFloat("Float"));
        Assert.assertEquals("String", model.getString("String"));
    }
}
