package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;
import com.rocketlabs.sellercenterapi.core.utils.Helper;

import java.util.HashMap;
import java.util.Map;

class OrderItemRepository extends AbstractRepository {

    /**
     * Returns the items for one or more orders.
     *
     * @param orders list of orders
     * @return list of order items
     * @throws SdkException
     */
    OrderItemCollection retrieve(OrderCollection orders) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderIdList", Helper.toParam(orders.getIds()));
        SuccessResponse response = requestApi("GetMultipleOrderItems", params);

        return new OrderItemCollection(response);
    }

    /**
     * Returns the items for one order
     *
     * @param order the order
     * @return list of order items
     * @throws SdkException
     */
    OrderItemCollection retrieve(Order order) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderId", order.getId());
        SuccessResponse response = requestApi("GetOrderItems", params);

        return new OrderItemCollection(response);
    }

    /**
     * Retrieve order-related documents
     *
     * @param items        List of order items
     * @param documentType One of 'invoice', 'shippingLabel', 'shippingParcel', 'carrierManifest', or 'serialNumber'
     * @return an order-related document
     * @throws SdkException
     */
    Document getDocument(OrderItemCollection items, String documentType) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderItemIds", Helper.toParam(items.getIds()));
        params.put("DocumentType", documentType);

        SuccessResponse response = requestApi("GetDocument", params);

        return new Document(response);
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToReadyToShip(OrderItemCollection items, ReadyToShipOptions opt) throws SdkException {
        Map<String, String> params = opt.toMap();
        params.put("OrderItemIds", Helper.toParam(items.getIds()));
        requestApi("SetStatusToReadyToShip", params);
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToPackedByMarketplace(OrderItemCollection items, PackedByMarketPlaceOptions opt) throws SdkException {
        Map<String, String> params = opt.toMap();
        params.put("OrderItemIds", Helper.toParam(items.getIds()));
        requestApi("SetStatusToPackedByMarketplace", params);
    }

    /**
     * @param items        List of oder items to be marked
     * @param reason       error context as returned by GetFailureReasons
     * @param details      additional explaining message
     * @throws SdkException
     */
    void setStatusToFailedDelivery(OrderItemCollection items, Reason reason, String details) throws SdkException {
        for (OrderItem item : items) {
            setStatusToFailedDelivery(item, reason, details);
        }
    }

    /**
     * @param item         item to be marked
     * @param reason       error context as returned by GetFailureReasons
     * @param details      additional explaining message
     * @throws SdkException
     */
    private void setStatusToFailedDelivery(OrderItem item, Reason reason, String details) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderItemId", item.getId());
        params.put("Reason", reason.getId());
        params.put("ReasonDetail", details);

        requestApi("SetStatusToFailedDelivery", params);
    }

    /**
     * @param items        List of oder items to be marked
     * @param reason       error context as returned by GetFailureReasons
     * @param details      additional explaining message
     * @throws SdkException
     */
    void setStatusToCanceled(OrderItemCollection items, Reason reason, String details) throws SdkException {
        for (OrderItem item : items) {
            setStatusToCanceled(item, reason, details);
        }
    }


    /**
     * @param item         item to be marked
     * @param reason       error context as returned by GetFailureReasons
     * @param details      additional explaining message
     * @throws SdkException
     */
    private void setStatusToCanceled(OrderItem item, Reason reason, String details) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderItemId", item.getId());
        params.put("Reason", reason.getId());
        params.put("ReasonDetail", details);

        requestApi("SetStatusToCanceled", params);
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToDelivered(OrderItemCollection items) throws SdkException {
        for (OrderItem item : items) {
            setStatusToDelivered(item);
        }
    }

    /**
     * @param item         item to be marked
     * @throws SdkException
     */
    private void setStatusToDelivered(OrderItem item) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderItemId", item.getId());

        requestApi("SetStatusToDelivered", params);
    }

    /**
     * @param items List of oder items to be marked
     * @throws SdkException
     */
    void setStatusToShipped(OrderItemCollection items) throws SdkException {
        for (OrderItem item : items) {
            setStatusToShipped(item);
        }
    }

    /**
     *
     * @param item         item to be marked
     * @throws SdkException
     */
    private void setStatusToShipped(OrderItem item) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("OrderItemId", item.getId());

        requestApi("SetStatusToShipped", params);
    }
}
