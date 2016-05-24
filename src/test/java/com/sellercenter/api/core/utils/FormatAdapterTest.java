package com.sellercenter.api.core.utils;

import junit.framework.TestCase;
import org.glassfish.json.JsonProviderImpl;
import org.junit.Assert;

import javax.json.JsonObjectBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatAdapterTest extends TestCase {

    public void testToXML() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        Map<String, Object> product = new HashMap<String, Object>();
        Map<String, Object> productData = new HashMap<String, Object>();
        /**
         *  <?xml version="1.0" encoding="UTF-8" ?>
         *  <Request>
         *      <Product>
         *          <SellerSku>4105382173aaee4</SellerSku>
         *          <Status>active</Status>
         *          <Name>Magic Product</Name>
         *          <Variation>XXL</Variation>
         *          <PrimaryCategory>4</PrimaryCategory>
         *          <Categories>2,3,5</Categories>
         *          <Description><![CDATA[This is a <b>bold</b> product.]]></Description>
         *          <Brand>ASM</Brand>
         *          <Price>1.00</Price>
         *          <ProductData>
         *              <Megapixels>490</Megapixels>
         *              <OpticalZoom>7</OpticalZoom>
         *              <SystemMemory>4</SystemMemory>
         *              <NumberCpus>32</NumberCpus>
         *              <Network>This is network</Network>
         *          </ProductData>
         *          <Quantity>10</Quantity>
         *      </Product>
         *      <Item>Hello</Item>
         *      <Item>World</Item>
         *      <Item>!!!</Item>
         *      <Item>:D</Item>
         *  </Request>
         */
        product.put("SellerSku", "4105382173aaee4");
        product.put("Status", "active");
        product.put("Name", "Magic Product");
        product.put("Variation", "XXL");
        product.put("PrimaryCategory", 4);
        product.put("Categories", "2, 3, 5");
        product.put("Description", "active");
        product.put("Brand", "active");
        product.put("Price", "active");
        product.put("Quantity", 10);

        productData.put("Megapixels", 490);
        productData.put("OpticalZoom", 7);
        productData.put("SystemMemory", 4);
        productData.put("NumberCpus", 32);
        productData.put("Network", "This is network");
        product.put("ProductData", productData);

        request.put("Product", product);

        List<Object> list = new ArrayList<Object>();
        list.add("Hello");
        list.add("World");
        list.add("!!!");
        list.add(":D");
        request.put("Item", list);

        String result = FormatAdapter.toXML(request, "Request");
        // @Todo : find a way to compare the strings
    }

    public void testFromJSON() throws Exception {
        /**
         *  {
         *      "SuccessResponse": {
         *          "Head": {
         *              "RequestId": "13e55362-3cc4-446b-b3db-c1df0900ae9e",
         *              "RequestAction": "PriceFeed",
         *              "ResponseType": "",
         *              "Timestamp": "2015-07-01T11:11:11+0000",
         *              "Array": ["Hello", "World", "!!!", ":D"]
         *          },
         *          "Body": ""
         *      }
         *  }
         */

        String jsonString = "{\n"
                + "  \"SuccessResponse\": {\n"
                + "    \"Head\": {\n"
                + "      \"RequestId\": \"13e55362-3cc4-446b-b3db-c1df0900ae9e\",\n"
                + "      \"RequestAction\": \"PriceFeed\",\n"
                + "      \"ResponseType\": \"\",\n"
                + "      \"Timestamp\": \"2015-07-01T11:11:11+0000\"\n,"
                + "      \"Array\": [\"Hello\", \"World\", \"!!!\", \":D\"]\n"
                + "    },\n"
                + "    \"Body\": \"\"\n"
                + "  }\n"
                + "}";
        Map<String, Object> map = FormatAdapter.fromJSON(jsonString);
        Assert.assertTrue("Primary key not found", map.containsKey("SuccessResponse"));

        Map<String, Object> response = (Map<String, Object>) map.get("SuccessResponse");
        Assert.assertTrue("Head key not found", response.containsKey("Head"));
        Assert.assertTrue("Body key not found", response.containsKey("Body"));
        Assert.assertEquals("", response.get("Body"));

        Map<String, Object> head = (Map<String, Object>) response.get("Head");
        Assert.assertEquals("13e55362-3cc4-446b-b3db-c1df0900ae9e", head.get("RequestId"));
        Assert.assertEquals("PriceFeed", head.get("RequestAction"));
        Assert.assertEquals("", head.get("ResponseType"));
        Assert.assertEquals("2015-07-01T11:11:11+0000", head.get("Timestamp"));

        List<Object> list = (List<Object>) head.get("Array");
        Assert.assertTrue(list.contains("Hello"));
        Assert.assertTrue(list.contains("World"));
        Assert.assertTrue(list.contains("!!!"));
        Assert.assertTrue(list.contains(":D"));
    }
}