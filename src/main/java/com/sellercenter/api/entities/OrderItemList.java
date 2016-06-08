package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.ResponseDataException;
import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class OrderItemList implements Iterable<OrderItem> {
    private List<OrderItem> items = new ArrayList<>();
    private OrderItemRepository repository = new OrderItemRepository();

    /**
     * @param response api response to GetOrderItems or GetMultipleOrderItems
     */
    OrderItemList(SuccessResponse response) throws SdkException {

        JsonObject body = response.getBody();

        JsonObject orders = body.getJsonObject("Orders");
        if (orders == null) { // single order via GetOrderItems
            extractItems(body);
        } else {
            JsonValue order = orders.get("Order");
            if (order instanceof JsonArray) { // multiple orders via GetMultipleOrderItems
                for (JsonValue o : ((JsonArray) order)) {
                    if (o instanceof JsonObject) {
                        extractItems((JsonObject) o);
                    }
                }
            } else if (order instanceof JsonObject) { // single orders via GetMultipleOrderItems
                extractItems((JsonObject) order);
            }
        }
    }

    /**
     * Parse JSON of body or order object and gather all order items
     *
     * @param container body or order json object
     */
    private void extractItems(JsonObject container) throws SdkException {
        if (container.getJsonObject("OrderItems") == null
                || container.getJsonObject("OrderItems").get("OrderItem") == null) {
            throw new ResponseDataException("Cannot create OrderItemList");
        }
        JsonValue orderItem = container.getJsonObject("OrderItems").get("OrderItem");
        if (orderItem instanceof JsonObject) {
            items.add(new OrderItem((JsonObject) orderItem));
        } else if (orderItem instanceof JsonArray) {
            for (JsonValue item : (JsonArray) orderItem) {
                if (item instanceof JsonObject) {
                    items.add(new OrderItem((JsonObject) item));
                }
            }
        }
    }

    /**
     * @param documentType One of 'invoice', 'shippingLabel', 'shippingParcel', 'carrierManifest', or 'serialNumber'
     * @return Document as string
     * @throws SdkException
     */
    public Document getDocument(String documentType) throws SdkException {
        return repository.getDocument(this, documentType);
    }

    /**
     * @throws SdkException
     */
    public void setStatusToPackedByMarketplace(PackedByMarketPlaceOptions options) throws SdkException {
        repository.setStatusToPackedByMarketplace(this, options);
    }

    /**
     * @throws SdkException
     */
    public void setStatusToReadyToShip(ReadyToShipOptions options) throws SdkException {
        repository.setStatusToReadyToShip(this, options);
    }

    /**
     * @throws SdkException
     */
    public void setStatusToFailedDelivery(Reason reason, String details) throws SdkException {
        this.repository.setStatusToFailedDelivery(this, reason, details);
    }

    /**
     * @param reason       error context as returned by GetFailureReasons
     * @param details additional explaining message
     * @throws SdkException
     */
    public void setStatusToCanceled(Reason reason, String details) throws SdkException {
        this.repository.setStatusToCanceled(this, reason, details);
    }

    /**
     * @throws SdkException
     */
    public void setStatusToDelivered() throws SdkException {
        repository.setStatusToDelivered(this);
    }

    /**
     * @throws SdkException
     */
    public void setStatusToShipped() throws SdkException {
        repository.setStatusToShipped(this);
    }

    /**
     * See interface Iterable
     *
     * @return iterator
     */
    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }

    /**
     * @return List of ids of all items
     */
    List<String> getIds() {
        List<String> res = new LinkedList<>();
        for (OrderItem item : items) {
            res.add(item.getId());
        }
        return res;
    }
}
