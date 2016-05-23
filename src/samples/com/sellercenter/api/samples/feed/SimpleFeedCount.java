package com.sellercenter.api.samples.feed;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.endpoints.SellerCenter;
import com.sellercenter.api.exceptions.ApiException;
import com.sellercenter.api.exceptions.SdkException;
import org.json.JSONObject;

public class SimpleFeedCount {

    public static void main(String[] args) throws Exception {

        SellerCenter.apiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.userId = "remy.rey@rocket-internet.com";
        SellerCenter.url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Create a request
         */
        Request req = new Request("FeedCount", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version);

        /**
         * Call the API
         */
        SuccessResponse success;
        try {
            success = Client.call(req, SellerCenter.url);
        } catch (ApiException e) {
            throw new Exception("Error : " + e.getMessage());
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
