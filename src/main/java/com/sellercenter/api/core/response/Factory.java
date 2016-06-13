package com.sellercenter.api.core.response;

import com.sellercenter.api.core.Response;

import javax.json.JsonObject;

public class Factory {

    /**
     * Build a response instance from the data stored in a JsonObject
     * which was retrieved from a API response
     *
     * @param json representation of the body of an API request
     * @return Response instance, Success or Error depending on API response
     */
    public static Response fromJsonObject(JsonObject json) {
        JsonObject response = json.getJsonObject("SuccessResponse");
        if (response != null) {
            return successFromJsonObject(response);
        }
        return errorFromJsonObject(json.getJsonObject("ErrorResponse"));
    }

    /**
     * Build a SuccessResponse
     *
     * @param response a json containing a 'Head' and 'Body'
     * @return Response instance
     */
    private static Response successFromJsonObject(JsonObject response) {
        JsonObject head = response.getJsonObject("Head");
        JsonObject jsonBody = null;
        if (response.get("Body") instanceof JsonObject) {
            jsonBody = response.getJsonObject("Body");
        }

        return new SuccessResponse(
                head.getString("RequestAction"),
                head.getString("ResponseType"),
                head.getString("Timestamp"),
                jsonBody
        );
    }

    /**
     * Build a ErrorResponse
     *
     * @param response a json containing a 'Head'
     * @return Response instance
     */
    private static Response errorFromJsonObject(JsonObject response) {
        JsonObject head = response.getJsonObject("Head");
        JsonObject jsonBody = null;
        if (response.get("Body") instanceof JsonObject) {
            jsonBody = response.getJsonObject("Body");
        }

        return new ErrorResponse(
                head.getString("RequestAction"),
                head.getString("ErrorType"),
                head.getString("ErrorCode"),
                head.getString("ErrorMessage"),
                jsonBody
        );
    }
}
