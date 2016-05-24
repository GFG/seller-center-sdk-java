package com.sellercenter.api.core.response;

import com.sellercenter.api.core.Response;
import com.sellercenter.api.exceptions.SdkException;
import junit.framework.TestCase;
import org.junit.Assert;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class FactoryTest extends TestCase {

    public void testError () {
        Response response = Factory.fromJsonObject(this.errorJsonProvider());
        ErrorResponse error = (ErrorResponse) response;

        Assert.assertEquals(error.getErrorCode(), 1);
        Assert.assertEquals(error.getErrorType(), "Sender");
        Assert.assertEquals(error.getRequestAction(), "GetOrder");
        Assert.assertEquals(error.getErrorMessage(), "E001: Parameter %s is mandatory");
    }

    public void testSuccess() {
        Response response = Factory.fromJsonObject(successJsonProvider());
        SuccessResponse success  = (SuccessResponse) response;

        Assert.assertEquals(success.getRequestAction(), "GetProducts");
        Assert.assertEquals(success.getResponseType(), "Products");
        Assert.assertEquals(success.getTimestamp(), "2015-07-01T11:11:11+0000");
    }

    private JsonObject successJsonProvider() {
        return Json.createObjectBuilder()
                .add("SuccessResponse", Json.createObjectBuilder()
                    .add("Head", Json.createObjectBuilder()
                        .add("RequestId", "1")
                        .add("RequestAction", "GetProducts")
                        .add("ResponseType", "Products")
                        .add("Timestamp", "2015-07-01T11:11:11+0000")
                    ).add("Body", Json.createObjectBuilder()
                        .add("Products", ""))
                ).build();
    }

    private JsonObject errorJsonProvider() {
        return Json.createObjectBuilder()
                .add("ErrorResponse", Json.createObjectBuilder()
                        .add("Head", Json.createObjectBuilder()
                                .add("RequestAction", "GetOrder")
                                .add("ErrorType", "Sender")
                                .add("ErrorCode", "1")
                                .add("ErrorMessage", "E001: Parameter %s is mandatory")
                        ).add("Body", "")
                ).build();
    }
}