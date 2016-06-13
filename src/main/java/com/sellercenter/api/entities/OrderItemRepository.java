package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.core.utils.Helper;
import com.sellercenter.api.exceptions.SdkException;

import java.util.HashMap;
import java.util.Map;

class OrderItemRepository {

    /**
     * Returns the items for one or more orders.
     *
     * @param orders list of orders
     * @return list of order items
     * @throws SdkException
     */
    OrderItemList retrieve(OrderList orders) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderIdList", Helper.toParam(orders.getIds()));
        SuccessResponse response = Client.call(
                new Request("GetMultipleOrderItems", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new OrderItemList(response);
    }

    /**
     * Returns the items for one order
     *
     * @param order the order
     * @return list of order items
     * @throws SdkException
     */
    OrderItemList retrieve(Order order) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderId", order.getOrderId());
        SuccessResponse response = Client.call(
                new Request("GetOrderItems", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new OrderItemList(response);
    }

    /**
     * Retrieve order-related documents
     *
     * @param items        List of order items
     * @param documentType One of 'invoice', 'shippingLabel', 'shippingParcel', 'carrierManifest', or 'serialNumber'
     * @return an order-related document
     * @throws SdkException
     */
    Document getDocument(OrderItemList items, String documentType) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderItemIds", Helper.toParam(items.getIds()));
        params.put("DocumentType", documentType);

        SuccessResponse response = Client.call(
                new Request("GetDocument", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new Document(response);
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToReadyToShip(OrderItemList items) throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToPackedByMarketplace(OrderItemList items) throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToFailedDelivery(OrderItemList items) throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     * @param items        List of oder items to be marked
     * @param reason       error context as returned by GetFailureReasons
     * @param reasonDetail additional explaining message
     * @throws SdkException
     */
    void setStatusToCanceled(OrderItemList items, String reason, String reasonDetail) throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToDelivered(OrderItemList items) throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToShipped(OrderItemList items) throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }
}
