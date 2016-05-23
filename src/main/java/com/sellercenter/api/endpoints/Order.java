package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import java.util.HashMap;
import java.util.Map;

public final class Order extends AbstractModel {


    public Order(String orderId) {
        super(null);
        data.put("OrderId", orderId);
    }

    Order(SuccessResponse response, Map<String, Object> data) {
        super(response);
        this.data = data;
        this.data.put("AddressBilling", new Address(response, (Map<String, Object>) this.data.get("AddressBilling")));
        this.data.put("AddressShipping", new Address(response, (Map<String, Object>) this.data.get("AddressShipping")));
    }

    public Order retrieve() throws SdkException {

        Map<String, String> params = new HashMap<String, String>();
        params.put("OrderId", getOrderId());
        SuccessResponse response = Client.call(
                new Request("GetOrder", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new Order(
                response,
                (Map<String, Object>) ((Map<String, Object>) response.getBody().get("Orders")).get("Order")
        );
    }

    public OrderItemList getItems() throws SdkException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("OrderId", getOrderId());
        SuccessResponse response = Client.call(
                new Request("GetOrderItems", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new OrderItemList(response);
    }

    /**
     *
     * ATTRIBUTES GETTERS AND SETTERS
     *
     */

    public String getOrderId() {
        return getString("OrderId");
    }

    public String getCustomerFirstName() {
        return getString("CustomerFirstName");
    }

    public String getCustomerLastName() {
        return getString("CustomerLastName");
    }

    public String getOrderNumber() {
        return getString("OrderNumber");
    }

    public String getPaymentMethod() {
        return getString("PaymentMethod");
    }

    public String getRemarks() {
        return getString("Remarks");
    }

    public String getDeliveryInfo() {
        return getString("DeliveryInfo");
    }

    public String getPrice() {
        return getString("Price");
    }

    public String getGiftOption() {
        return getString("GiftOption");
    }

    public String getGiftMessage() {
        return getString("GiftMessage");
    }

    public String getVoucherCode() {
        return getString("VoucherCode");
    }

    public String getCreatedAt() {
        return getString("CreatedAt");
    }

    public String getUpdatedAt() {
        return getString("UpdatedAt");
    }

    public Address getAddressBilling() {
        return (Address) data.get("AddressBilling");
    }

    public Address getAddressShipping() {
        return (Address) data.get("AddressShipping");
    }

    public String getNationalRegistrationNumber() {
        return getString("NationalRegistrationNumber");
    }

    public String getItemsCount() {
        return getString("ItemsCount");
    }

    public String getExtraAttributes() {
        return getString("ExtraAttributes");
    }

}
