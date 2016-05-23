package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.response.SuccessResponse;

import java.util.Map;

/**
 * Submodel for ProductData in a Product
 * Provide getters and setters to all attributes
 */
public final class ProductData extends AbstractModel {

    /*
    private float CommissionFeeSimple;
    private String PackageType;
    private int MinDeliveryTime;
    private int MaxDeliveryTime;
    private String Sourceability;
    private String SupplierName;
    private String Model;
    private String SupplierType;
    private float PackageHeight;
    private float PackageLength;
    private float PackageWidth;
    private float PackageWeight;
    private String ShortDescription;
    */

    ProductData(SuccessResponse response, Map<String, Object> data) {
        super(response);
        this.data = data;
    }

    public float getCommissionFeeSimple() {
        return getFloat("CommissionFeeSimple");
    }

    public int getMaxDeliveryTime() {
        return getInt("MaxDeliveryTime");
    }

    public int getMinDeliveryTime() {
        return getInt("MinDeliveryTime");
    }

    public String getModel() {
        return getString("Model");
    }

    public float getPackageHeight() {
        return getFloat("PackageHeight");
    }

    public float getPackageLength() {
        return getFloat("PackageLength");
    }

    public String getPackageType() {
        return getString("PackageType");
    }

    public float getPackageWeight() {
        return getFloat("PackageWeight");
    }

    public float getPackageWidth() {
        return getFloat("PackageWidth");
    }

    public String getShortDescription() {
        return getString("ShortDescription");
    }

    public String getSourceability() {
        return getString("Sourceability");
    }

    public String getSupplierName() {
        return getString("SupplierName");
    }

    public String getSupplierType() {
        return getString("SupplierType");
    }

    public ProductData setCommissionFeeSimple(float commissionFeeSimple) {
        data.put("CommissionFeeSimple", commissionFeeSimple);
        return this;
    }

    public ProductData setMaxDeliveryTime(int maxDeliveryTime) {
        data.put("MaxDeliveryTime", maxDeliveryTime);
        return this;
    }

    public ProductData setMinDeliveryTime(int minDeliveryTime) {
        data.put("MinDeliveryTime", minDeliveryTime);
        return this;
    }

    public ProductData setModel(String model) {
        data.put("Model", model);
        return this;
    }

    public ProductData setPackageHeight(float packageHeight) {
        data.put("PackageHeight", packageHeight);
        return this;
    }

    public ProductData setPackageLength(float packageLength) {
        data.put("PackageLength", packageLength);
        return this;
    }

    public ProductData setPackageType(String packageType) {
        data.put("PackageType", packageType);
        return this;
    }

    public ProductData setPackageWeight(float packageWeight) {
        data.put("PackageWeight", packageWeight);
        return this;
    }

    public ProductData setPackageWidth(float packageWidth) {
        data.put("PackageWidth", packageWidth);
        return this;
    }

    public ProductData setShortDescription(String shortDescription) {
        data.put("ShortDescription", shortDescription);
        return this;
    }

    public ProductData setSourceability(String sourceability) {
        data.put("Sourceability", sourceability);
        return this;
    }

    public ProductData setSupplierName(String supplierName) {
        data.put("SupplierName", supplierName);
        return this;
    }

    public ProductData setSupplierType(String supplierType) {
        data.put("SupplierType", supplierType);
        return this;
    }
}

