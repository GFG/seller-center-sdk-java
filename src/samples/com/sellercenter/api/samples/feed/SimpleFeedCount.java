package com.sellercenter.api.samples.feed;

import com.sellercenter.api.Config;
import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.core.response.ErrorResponse;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;
import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.Request;
import com.sellercenter.api.core.Response;
import com.sellercenter.api.core.request.Get;
import com.sellercenter.api.exceptions.ApiException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SimpleFeedCount {

    public static void main(String[] args) throws Exception {

        SellerCenter.ApiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.UserId = "remy.rey@rocket-internet.com";
        SellerCenter.Url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Create a request
         */
        Map<String, String> params = new HashMap<String, String>();
        Map<String, Object> body = new HashMap<String, Object>();

        params.put("Action", "FeedCount");
        params.put("UserID", SellerCenter.UserId);
        params.put("Version", Config.VERSION);

        Request get = new Get(params, SellerCenter.ApiKey);

        /**
         * Call the API
         */
        Response res;
        try {
            res = Client.call(get, SellerCenter.Url);
        } catch (ApiException e) {
            throw new Exception("Error : " + e.getMessage());
        } catch (SdkException e) {
            throw new Exception("Error : " + e.getMessage());
        }

        /**
         * Pretty print the response
         */
        if (res.isError()) {
            ErrorResponse err = (ErrorResponse) res;
            System.out.println("Error :");
            System.out.println(">   Code : " + err.getErrorCode());
            System.out.println(">   Message : " + err.getErrorMessage());
            System.out.println(">   (" + err.getErrorType() + ")");
        } else {
            SuccessResponse succ = (SuccessResponse) res;
            System.out.println("Success :");
            System.out.println(">   " + succ.getResponseType());
            System.out.println(">   " + succ.getTimestamp());
            JSONObject json = new JSONObject(res.getBody());
            System.out.println("BODY :");
            System.out.println(json.toString(4));
        }
    }
}
