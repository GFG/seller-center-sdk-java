package com.sellercenter.api.endpoints;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.endpoints.orders.GetOrderRequest;
import com.sellercenter.api.endpoints.orders.GetOrderResponse;
import com.sellercenter.api.endpoints.orders.SetStatusToCanceledRequest;
import com.sellercenter.api.exceptions.*;

public class Orders extends SellerCenter {

    /**
     * Performs a GetOrder request
     *
     * @param orderId The order identifier that was assigned to the order by SellerCenter.
     *
     * @return A specific success response
     *
     * @throws SdkException
     * @throws ApiException
     * @throws RateLimitException
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     */
    public static GetOrderResponse getOrder(int orderId)
            throws SdkException, ApiException, RateLimitException, AuthenticationException, InvalidRequestException, ResourceNotFoundException {
        return new GetOrderResponse(Client.call(
                new GetOrderRequest(getUserId(), getApiKey(), getVersion(), orderId),
                getUrl()
        ));
    }

    /**
     * Performs a SetStatusToCanceled request
     *
     * @param orderId The order identifier that was assigned to the order by SellerCenter.
     * @param reason
     * @param reasonDetail
     *
     * @return A specific success response
     *
     * @throws RateLimitException
     * @throws ApiException
     * @throws SdkException
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     */
    public static SuccessResponse setStatusToCanceled(int orderId, String reason, String reasonDetail)
            throws RateLimitException, ApiException, SdkException, AuthenticationException, InvalidRequestException, ResourceNotFoundException {

        return Client.call(
            new SetStatusToCanceledRequest(
                getUserId(),
                getApiKey(),
                getVersion(),
                Integer.toString(orderId),
                reason,
                reasonDetail
            ),
            getUrl()
        );
    }
}
