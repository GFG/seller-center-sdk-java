package com.sellercenter.api.core;

import com.jcabi.http.request.ApacheRequest;
import com.jcabi.http.response.JsonResponse;
import com.sellercenter.api.core.request.Method;
import com.sellercenter.api.core.response.ErrorResponse;
import com.sellercenter.api.core.response.Factory;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.core.utils.FormatAdapter;
import com.sellercenter.api.endpoints.SellerCenter;
import com.sellercenter.api.exceptions.*;

import java.io.IOException;

public class Client {

    /**
     * call the api with a given request
     * and url of SellerCenter or Config
     *
     * @param request Request to be cast
     *
     * @return Response of the Api
     *
     * @throws SdkException
     * @throws ApiException
     */
    public static SuccessResponse call(Request request)
            throws SdkException, ApiException, RateLimitException, AuthenticationException, InvalidRequestException, ResourceNotFoundException {
        return call(request, SellerCenter.url);
    }

    /**
     * Call the api with a given request
     * Throw an exception if API returns an error
     *
     * @param request Request to be cast
     * @param url URL of Seller Center instance
     *
     * @return Response of the Api
     *
     * @throws ApiException
     * @throws SdkException
     */
    public static SuccessResponse call(Request request, String url)
            throws ApiException, SdkException, InvalidRequestException, AuthenticationException, RateLimitException, ResourceNotFoundException {

        com.jcabi.http.response.JsonResponse response;
        try {
            com.jcabi.http.Request requestToSend = new ApacheRequest(url)
                    .method(translateMethod(request.getMethod()))

                    .uri()
                    .queryParams(request.getParams())
                    .back();

            if (request.getMethod() ==  Method.POST) {
                requestToSend
                        .body()
                        .set(FormatAdapter.toXML(request.getBody(), "Request"))
                        .back();
            }

            response = requestToSend.fetch()

                    .as(JsonResponse.class);
        } catch (IOException e) {
            throw new SdkException("Http Client encountered a problem : " + e.getMessage());
        }

        if (response.status() != 200) {
            throw new ApiException("API error : " + response.status() + " : " + response.reason());
        }

        Response res = Factory.fromJsonObject(response.json().readObject());
        if (res.isError()) {
            ErrorResponse err = (ErrorResponse) res;
            switch (((ErrorResponse) res).getErrorCode()) {
                case 1: // mandatory param
                case 2: // invalid version
                case 3: // timestamp expired
                case 4: // invalid timestamp format
                case 5: // invalid request format
                case 8: // invalid action
                case 11: // request too big
                case 12: // invalid feed ID
                case 13: // invalid feed status
                case 14: // invalid offset
                case 15: // invalid page size
                case 16: // invalid order ID
                case 17: // invalid date format
                case 19: // invalid limit
                case 20: // invalid order item id
                case 22: // invalid reason
                case 23: // invalid reason
                case 24: // invalid delivery type
                case 25: // invalid shipping provider
                case 32: // invalid doc type
                case 31: // incorrect tracking id
                case 36: // invalid status filter
                case 37: // id incorrect
                case 38: // too many orders requested
                case 46: // invalid CreationDate value
                case 47: // invalid UpdatedDate value
                case 53: // FeedIdList must be array
                case 54: // FeedIdList must be array
                case 56: // OrdersIdList must be array
                case 70: // corrupt sku list data
                case 74: // invalid sort direction
                case 75: // invalid sort filter
                case 89: // field ManifestCodes is missing
                    throw new InvalidRequestException(err.getErrorMessage());

                case 21: // OMS api error occurred
                case 28: // "impossible to set order to status %s"
                case 29: // "order items must be from the same order"
                case 34: // "Order Item must be packed. Please call setStatusToReadyToShip before"
                case 63: // "The tracking code %s has already been used"
                case 64: // "No categories linked to provided attribute sets"
                case 73: // "All order items must have status Pending or Ready To Ship"
                case 87: // "Manifest feature is not enabled"
                case 90: // "Manifest status can not set to shipped"
                case 91: // "Please use sent_to_warehouse"
                case 93: // "This api call '%s' is currently not allowed"
                    throw new ApiException("Impossible request : " + err.getErrorMessage());

                case 35: // "'%s' not found"
                case 39: // "No orders were found"
                case 57: // "No attribute sets linked to that category"
                case 62: // "No seller was found by e-mail %s"
                case 88: // "Manifest was not found"
                    throw new ResourceNotFoundException(err.getErrorMessage());

                case 6: // "Unexpected internal error"
                case 1000: // "Internal Application Error" | "Format Error Detected"
                    throw new ApiException("Internal API error : " + err.getErrorMessage());

                case 7: // signature problem
                case 9: // access denied
                    throw new AuthenticationException(err.getErrorMessage());

                case 429: // throttling
                    throw new RateLimitException(err.getErrorMessage());

                case 30: // empty request
                case 10: // insecure channel
                default:
                    throw new SdkException("Unexpected API error occurred : " + err.getErrorMessage());
            }
        }

        return (SuccessResponse) res;
    }


    /**
     * @param   method  One of the static method name specified in Request interface
     * @return  String  A method name compliant with jcabi http client
     * @throws  SdkException when method is invalid
     */
    private static String translateMethod(Method method) throws SdkException {
        if (method == Method.GET) {
            return com.jcabi.http.Request.GET;
        }

        if (method == Method.POST) {
            return com.jcabi.http.Request.POST;
        }

        throw new SdkException("Request Method '" + method + "' is invalid");
    }
}
