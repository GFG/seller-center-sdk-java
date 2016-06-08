package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonObject;

public final class Order extends AbstractModel {

    private OrderItemRepository itemRepository = new OrderItemRepository();

    private final Address addressBilling;
    private final Address addressShipping;

    /**
     * Constructor
     *
     * @param data Json load from response body
     */
    Order(JsonObject data) {
        super(data);
        this.addressBilling = new Address(this.data.getJsonObject("AddressBilling"));
        this.addressShipping = new Address(this.data.getJsonObject("AddressShipping"));
    }

    /**
     * Constructor
     *
     * @param response response from API
     */
    Order(SuccessResponse response) {
        this(response.getBody().getJsonObject("Orders").getJsonObject("Order"));
    }

    /**
     * Returns the items for one order
     *
     * @return list of order items
     * @throws SdkException
     */
    public OrderItemList getItems() throws SdkException {
        return this.itemRepository.retrieve(this);
    }

    /**
     * ATTRIBUTES GETTERS AND SETTERS
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
        return addressBilling;
    }

    public Address getAddressShipping() {
        return addressShipping;
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
