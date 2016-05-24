package com.sellercenter.api.core.response;

import com.sellercenter.api.core.Response;
import com.sellercenter.api.core.utils.FormatAdapter;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.HashMap;
import java.util.Map;

public class Factory {

    /**
     * Build a response instance from the data stored in a JsonObject
     * which was retrieved from a API response
     *
     * @param json representation of the body of an API request
     * @return
     */
    public static Response fromJsonObject(JsonObject json) {
        JsonObject response = json.getJsonObject("SuccessResponse");
        if (response != null) {
            return successFromJsonObject(response);
        }
        return errorFromJsonObject(json.getJsonObject("ErrorResponse"));
    }

    /**
     * Build a SuccessReponse
     *
     * @param response a json containing a 'Head' and 'Body'
     * @return
     */
    private static Response successFromJsonObject(JsonObject response) {
        JsonObject head = response.getJsonObject("Head");
        Map<String, Object> body = retrieveBody(response);

        return new SuccessResponse(
                head.getString("RequestAction"),
                head.getString("ResponseType"),
                head.getString("Timestamp"),
                body
        );
    }

    /**
     * Build a ErrorResponse
     *
     * @param response a json containing a 'Head'
     * @return
     */
    private static Response errorFromJsonObject(JsonObject response) {
        JsonObject head = response.getJsonObject("Head");
        Map<String, Object> body = retrieveBody(response);

        return new ErrorResponse(
                head.getString("RequestAction"),
                head.getString("ErrorType"),
                head.getString("ErrorCode"),
                head.getString("ErrorMessage"),
                body);
    }

    /**
     * Retrieve the value of the body of a request.
     * If the value is not a json object, it will return an empty map.
     *
     * @param response a json object containing a 'Body'
     * @return a map representation of the body.
     */
    private static Map<String, Object> retrieveBody(JsonObject response) {
        JsonValue value = response.get("Body");

        Map<String, Object> body;
        if (value instanceof JsonObject) {
            body = FormatAdapter.fromJSON(value.toString());
        } else {
            body = new HashMap<String, Object>();
        }

        return body;
    }
}
