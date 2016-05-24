package com.sellercenter.api.endpoints;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.core.Client;
import com.sellercenter.api.endpoints.orders.*;
import com.sellercenter.api.exceptions.*;

import java.util.List;

public class Orders extends SellerCenter {

    /**
     * Performs a GetOrder request
     *
     * @param orderId The order identifier that was assigned to the order by SellerCenter.
     * @return A specific success response
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
     * @param orderItemId      The order identifier that was assigned to the order by SellerCenter.
     * @param reason
     * @param reasonDetail
     * @return A specific success response
     * @throws RateLimitException
     * @throws ApiException
     * @throws SdkException
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     */
    public static SetStatusToCanceledResponse setStatusToCanceled(int orderItemId, String reason, String reasonDetail)
            throws RateLimitException, ApiException, SdkException, AuthenticationException, InvalidRequestException,
            ResourceNotFoundException {

        return new SetStatusToCanceledResponse(
                Client.call(
                        new SetStatusToCanceledRequest(
                                getUserId(),
                                getApiKey(),
                                getVersion(),
                                orderItemId,
                                reason,
                                reasonDetail
                        ),
                        getUrl()
                )
        );
    }

    public static GetDocumentResponse getDocument(String documentType, List<Integer> orderItemIds)
            throws ResourceNotFoundException, InvalidRequestException, ApiException, RateLimitException, SdkException,
            AuthenticationException {

        return new GetDocumentResponse(
                Client.call(
                        new GetDocumentRequest(getUserId(), getApiKey(), getVersion(), documentType, orderItemIds),
                        getUrl()
                )
        );
    }

    public static GetOrdersResponse getOrders()
            throws ResourceNotFoundException, InvalidRequestException, ApiException, RateLimitException, SdkException,
            AuthenticationException {

        return getOrders(new GetOrdersOptions());
    }

    public static GetOrdersResponse getOrders(GetOrdersOptions opt)
            throws ResourceNotFoundException, RateLimitException, ApiException, InvalidRequestException, SdkException,
            AuthenticationException {

        return new GetOrdersResponse(
                Client.call(
                        new GetOrdersRequest(getUserId(), getApiKey(), getVersion(), opt),
                        getUrl()
                )
        );
    }

    public static GetOrderItemsResponse getOrderItems(int orderId)
            throws ResourceNotFoundException, RateLimitException, ApiException, InvalidRequestException, SdkException,
            AuthenticationException {

        return new GetOrderItemsResponse(
                Client.call(
                        new GetOrderItemsRequest(getUserId(), getApiKey(), getVersion(), orderId),
                        getUrl()
                )
        );
    }

    public static SetStatusToReadyToShipResponse setStatusToReadyToShip(
            List<Integer> orderItemIds, String deliveryType, String shippingProvider, int trackingNumber)
            throws ResourceNotFoundException, InvalidRequestException, ApiException, RateLimitException,
            SdkException, AuthenticationException {

        return new SetStatusToReadyToShipResponse(
                Client.call(
                        new SetStatusToReadyToShipRequest(getUserId(), getApiKey(), getVersion(),
                                orderItemIds, deliveryType, shippingProvider, trackingNumber),
                        getUrl()
                )
        );
    }

    public static SetStatusToPackedByMarketplaceResponse setStatusToPackedByMarketplace(
            List<Integer> orderItemIds, String deliveryType, String shippingProvider)
            throws ResourceNotFoundException, InvalidRequestException, ApiException,
            RateLimitException, SdkException, AuthenticationException {

        return new SetStatusToPackedByMarketplaceResponse(
                Client.call(
                        new SetStatusToPackedByMarketplaceRequest(getUserId(), getApiKey(), getVersion(),
                                orderItemIds, deliveryType, shippingProvider),
                        getUrl()
                )
        );
    }
}
