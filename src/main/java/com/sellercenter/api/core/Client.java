package com.sellercenter.api.core;

import com.jcabi.http.request.ApacheRequest;
import com.jcabi.http.response.JsonResponse;
import com.sellercenter.api.core.response.Factory;
import com.sellercenter.api.core.utils.FormatAdapter;
import com.sellercenter.api.exceptions.SdkException;
import com.sellercenter.api.exceptions.ApiException;

import java.io.IOException;

public class Client {

    /**
     * call the api with a given request
     * @param request Request to be cast
     * @param url
     * @return Response
     * @throws ApiException If the http response has not a success code
     * @throws SdkException If the http client fails
     */
    public static Response call(Request request, String url) throws ApiException, SdkException {

        com.jcabi.http.response.JsonResponse response;
        try {
            com.jcabi.http.Request requestToSend = new ApacheRequest(url)
                    .method(translateMethod(request.getMethod()))

                    .uri()
                    .queryParams(request.getParams())
                    .back()

                    .body()
                    .set(FormatAdapter.toXML(request.getBody(), "Request"))
                    .back();

            response = requestToSend.fetch()

                    .as(JsonResponse.class);
        } catch (IOException e) {
            throw new SdkException("Http Client encountered a problem : " + e.getMessage());
        }

        if (response.status() != 200) {
            throw new ApiException("Internal API error : " + response.status() + " : " + response.reason());
        }

        return Factory.fromJsonObject(response.json().readObject());
    }


    /**
     * @param   method  One of the static method name specified in Request interface
     * @return  String  A method name compliant with jcabi http client
     * @throws  SdkException when method is invalid
     */
    private static String translateMethod(String method) throws SdkException {
        if (method.equals(Request.GET)) {
            return com.jcabi.http.Request.GET;
        }

        if (method.equals(Request.POST)) {
            return com.jcabi.http.Request.POST;
        }

        throw new SdkException("Request Method '" + method + "' is invalid");
    }
}
