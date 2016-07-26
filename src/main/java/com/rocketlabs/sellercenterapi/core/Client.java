package com.rocketlabs.sellercenterapi.core;

import com.jcabi.http.request.ApacheRequest;
import com.jcabi.http.response.JsonResponse;
import com.rocketlabs.sellercenterapi.core.request.Method;
import com.rocketlabs.sellercenterapi.core.response.ErrorType;
import com.rocketlabs.sellercenterapi.core.response.Factory;
import com.rocketlabs.sellercenterapi.core.utils.FormatAdapter;
import com.rocketlabs.sellercenterapi.entities.SellerCenter;
import com.rocketlabs.sellercenterapi.exceptions.ApiException;
import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.core.response.ErrorResponse;
import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

import java.io.IOException;

public class Client {

    /**
     * call the api with a given request
     * and url of SellerCenter or Config
     *
     * @param request Request to be cast
     * @return Response of the Api
     * @throws SdkException
     * @throws ApiException
     */
    public static SuccessResponse call(Request request)
            throws SdkException {
        return call(request, SellerCenter.url);
    }

    /**
     * Call the api with a given request
     * Throw an exception if API returns an error
     *
     * @param request Request to be cast
     * @param url     URL of Seller Center instance
     * @return Response of the Api
     * @throws ApiException
     * @throws SdkException
     */
    public static SuccessResponse call(Request request, String url)
            throws SdkException {

        com.jcabi.http.response.JsonResponse response;
        try {
            com.jcabi.http.Request requestToSend = new ApacheRequest(url)
                    .method(request.getMethod().toString())

                    .uri()
                    .queryParams(request.getParams())
                    .back();

            if (request.getMethod() == Method.POST) {
                requestToSend = requestToSend
                        .body()
                        .set(FormatAdapter.toXML(request.getBody(), "Request"))
                        .back();
            }
            response = requestToSend.fetch()

                    .as(JsonResponse.class);
        } catch (IOException e) {
            throw new SdkException("Http Client encountered a problem", e);
        }

        if (response.status() != 200) {
            throw new ApiException("API error : " + response.status() + " : " + response.reason());
        }

        Response res = Factory.fromJsonObject(response.json().readObject());
        if (res instanceof ErrorResponse) {
            ErrorResponse err = (ErrorResponse) res;
            try {
                throw ErrorType
                        .getByErrorNumber(err.getErrorCode())
                        .getException(err.getErrorMessage());
            } catch (ReflectiveOperationException e) {
                throw new SdkException("Problem occurred processing error response", e);
            }
        }

        if (res instanceof SuccessResponse) {
            return (SuccessResponse) res;
        } else {
            throw new SdkException("Client encountered a problem while processing the response (response should be " +
                    "instance of " + SuccessResponse.class + " is instead instance of " + res.getClass());
        }
    }
}
