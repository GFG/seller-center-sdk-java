package com.sellercenter.api.models.Order;

import com.sellercenter.api.core.response.AbstractModel;

import java.util.Date;
import java.util.Map;

public class OrderItem extends AbstractModel {

    public OrderItem(Map<String, Object> data) {
        super(data);
    }

    public int getOrderItemId() {
        return getInt("OrderItemId");
    }

    public int getShopId() {
        return getInt("ShopId");
    }

    public int getOrderId() {
        return getInt("OrderId");
    }

    public String getName() {
        return getString("Name");
    }

    public String getSku() {
        return getString("Sku");
    }

    public String getShopSku() {
        return getString("ShopSku");
    }

    public String getShippingType() {
        return getString("ShippingType");
    }

    public float getItemPrice() {
        return getFloat("ItemPrice");
    }

    public float getPaidPrice() {
        return getFloat("PaidPrice");
    }

    public float getWalletCredits() {
        return getFloat("WalletCredits");
    }

    public float getTaxAmount() {
        return getFloat("TaxAmount");
    }

    public float getShippingAmount() {
        return getFloat("ShippingAmount");
    }

    public int getVoucherAmount() {
        return getInt("VoucherAmount");
    }

    public String getVoucherCode() {
        return getString("VoucherCode");
    }

    public String getStatus() {
        return getString("Status");
    }

    public String getShipmentProvider() {
        return getString("ShipmentProvider");
    }

    public int getIsDigital() {
        return getInt("IsDigital");
    }

    public String getDigitalDeliveryInfo() {
        return getString("DigitalDeliveryInfo");
    }

    public int getTrackingCode() {
        return getInt("TrackingCode");
    }

    public String getReason() {
        return getString("Reason");
    }

    public String getReasonDetail() {
        return getString("ReasonDetail");
    }

    public int getPurchaseOrderId() {
        return getInt("PurchaseOrderId");
    }

    public String getPurchaseOrderNumber() {
        return getString("PurchaseOrderNumber");
    }

    public String getPackageId() {
        return getString("PackageId");
    }

    public Date getPromisedShippingTimes() {
        return getDate("PromisedShippingTimes");
    }

    public String getShippingProviderType() {
        return getString("ShippingProviderType");
    }

    public String getExtraAttributes() {
        return getString("ExtraAttributes");
    }

    public Date getCreatedAt() {
        return getDate("CreatedAt");
    }

    public Date getUpdatedAt() {
        return getDate("UpdatedAt");
    }

}
