package com.sellercenter.api.samples.feed;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;
import com.sellercenter.api.samples.Config;
import org.json.JSONObject;

public class SimpleFeedCount {

    public static void main(String[] args) throws Exception {

        /**
         * Create a request
         */
        Request req = new Request("FeedCount", Config.userId, Config.apiKey, Config.version);

        /**
         * Call the API
         */
        SuccessResponse success;
        try {
            success = Client.call(req, Config.url);
        } catch (SdkException e) {
            throw new Exception("Error : " + e.getMessage());
        }

        /**
         * Pretty print the response
         */
        System.out.println("Success :");
        System.out.println(">   " + success.getResponseType());
        System.out.println(">   " + success.getTimestamp());
        JSONObject json = new JSONObject(success.getBody());
        System.out.println("BODY :");
        System.out.println(json.toString(4));
    }
}
