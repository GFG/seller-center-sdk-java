package com.sellercenter.api.models.Order;

import com.sellercenter.api.core.response.AbstractModel;
import com.sellercenter.api.models.Address;

import java.util.Map;

public class Order extends AbstractModel {

    public Order(Map<String, Object> data) {
        super(data);
        this.data.put("AddressBilling", new Address((Map<String, Object>) data.get("AddressBilling")));
        this.data.put("AddressShipping", new Address((Map<String, Object>) data.get("AddressShipping")));
    }

    /*
    private String OrderId;
    private String CustomerFirstName;
    private String CustomerLastName;
    private String OrderNumber;
    private String PaymentMethod;
    private String Remarks;
    private String DeliveryInfo;
    private String Price;
    private String GiftOption;
    private String GiftMessage;
    private String VoucherCode;
    private String CreatedAt;
    private String UpdatedAt;
    private String AddressBilling;
    private String AddressShipping;
    private String NationalRegistrationNumber;
    private String ItemsCount;
    private String ExtraAttributes;
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
