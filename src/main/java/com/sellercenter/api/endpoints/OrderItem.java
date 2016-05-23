package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class OrderItem extends AbstractModel {

    /**
     *
     * @param id identifier of the order item
     */
    public OrderItem(String id) {
        super(null);
        this.data.put("OrderItemId", id);
    }

    OrderItem(SuccessResponse response, Map<String, Object> data) {
        super(response);
        this.data = data;
    }

    /**
     *
     * @param reason error context as retrieved with "GetFailureReasons"
     * @param reasonDetail more detailed explaining message (custom)
     * @throws SdkException
     */
    public void setStatusToCanceled(String reason, String reasonDetail) throws SdkException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("OrderItemId", getId());
        params.put("Reason", reason);
        params.put("ReasonDetail", reasonDetail);

        SuccessResponse response = Client.call(
                new Request("setStatusToCanceled", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );
    }

    public Order setStatusToPackedByMarketplace() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    public Order setStatusToReadyToShip() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    public Order setStatusToFailedDelivery() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    public Order setStatusToDelivered() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    public Order setStatusToShipped() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     *
     * ATTRIBUTES GETTERS AND SETTERS
     *
     */

    public String getId() {
        return getString("OrderItemId");
    }

    public int getShopId() {
        return getInt("ShopId");
    }

    public String getOrderId() {
        return getString("OrderId");
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
