package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.response.SuccessResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Model for Product
 * Provide getters and setters to all mandatory attributes
 */
public final class Product extends AbstractModel {

    /*
    private String SellerSku;
    private String ShopSku;
    private String Name;
    private String Brand;
    private String Description;
    private String TaxClass;
    private String Variation;
    private String ParentSku;
    private int Quantity;
    private int FulfillmentByNonSellable;
    private int Available;
    private float Price;
    private String SalePrice;
    private String SaleStartDate;
    private String SaleEndDate;
    private String Status;
    private String ProductId;
    private String url;
    private String MainImage;
    private List<String> Images;
    private String PrimaryCategory;
    private String Categories;
    private ProductData ProductData;
    */

    public Product(SuccessResponse response, Map<String, Object> data) {
        super(response);
        this.data = data;

        Object images = ((Map) data.get("Images")).get("Image");
        if (images instanceof List) {
            this.data.put("Images", images);
        } else {
            List<String> imageList = new LinkedList<String>();
            imageList.add((String) images);
            this.data.put("Images", imageList);
        }

        this.data.put("ProductData", new ProductData(response, (Map<String, Object>) data.get("ProductData")));
    }

    public int getAvailable() {
        return getInt("Available");
    }

    public String getBrand() {
        return getString("Brand");
    }

    public String getCategories() {
        return getString("Categories");
    }

    public String getDescription() {
        return getString("Description");
    }

    public int getFulfillmentByNonSellable() {
        return getInt("FulfillmentByNonSellable");
    }

    public List<String> getImages() {
        return (List<String>) data.get("Images");
    }

    public String getMainImage() {
        return getString("MainImage");
    }

    public String getName() {
        return getString("Name");
    }

    public String getParentSku() {
        return getString("ParentSku");
    }

    public float getPrice() {
        return getFloat("Price");
    }

    public String getPrimaryCategory() {
        return getString("PrimaryCategory");
    }

    public ProductData getProductData() {
        return (ProductData) data.get("ProductData");
    }

    public String getProductId() {
        return getString("ProductId");
    }

    public int getQuantity() {
        return getInt("Quantity");
    }

    public String getSaleEndDate() {
        return getString("SaleEndDate");
    }

    public String getSalePrice() {
        return getString("SalePrice");
    }

    public String getSaleStartDate() {
        return getString("SaleStartDate");
    }

    public String getSellerSku() {
        return getString("SellerSku");
    }

    public String getShopSku() {
        return getString("ShopSku");
    }

    public String getStatus() {
        return getString("Status");
    }

    public String getTaxClass() {
        return getString("TaxClass");
    }

    public String getUrl() {
        return getString("url");
    }

    public String getVariation() {
        return getString("Variation");
    }

    public Product setAvailable(int available) {
        data.put("Available", available);
        return this;
    }

    public Product setBrand(String brand) {
        data.put("Brand", brand);
        return this;
    }

    public Product setCategories(String categories) {
        data.put("Categories", categories);
        return this;
    }

    public Product setDescription(String description) {
        data.put("Description", description);
        return this;
    }

    public Product setFulfillmentByNonSellable(int fulfillmentByNonSellable) {
        data.put("FulfillmentByNonSellable", fulfillmentByNonSellable);
        return this;
    }

    public Product setImages(List<String> images) {
        data.put("Images", images);
        return this;
    }

    public Product setMainImage(String mainImage) {
        data.put("MainImage", mainImage);
        return this;
    }

    public Product setName(String name) {
        data.put("Name", name);
        return this;
    }

    public Product setParentSku(String parentSku) {
        data.put("ParentSku", parentSku);
        return this;
    }

    public Product setPrice(float price) {
        data.put("Price", price);
        return this;
    }

    public Product setPrimaryCategory(String primaryCategory) {
        data.put("PrimaryCategory", primaryCategory);
        return this;
    }

    public Product setProductData(ProductData productData) {
        data.put("ProductData", productData);
        return this;
    }

    public Product setProductId(String productId) {
        data.put("ProductId", productId);
        return this;
    }

    public Product setQuantity(int quantity) {
        data.put("Quantity", quantity);
        return this;
    }

    public Product setSaleEndDate(String saleEndDate) {
        data.put("SaleEndDate", saleEndDate);
        return this;
    }

    public Product setSalePrice(String salePrice) {
        data.put("SalePrice", salePrice);
        return this;
    }

    public Product setSaleStartDate(String saleStartDate) {
        data.put("SaleStartDate", saleStartDate);
        return this;
    }

    public Product setSellerSku(String sellerSku) {
        data.put("SellerSku", sellerSku);
        return this;
    }

    public Product setShopSku(String shopSku) {
        data.put("ShopSku", shopSku);
        return this;
    }

    public Product setStatus(String status) {
        data.put("Status", status);
        return this;
    }

    public Product setTaxClass(String taxClass) {
        data.put("TaxClass", taxClass);
        return this;
    }

    public Product setUrl(String url) {
        data.put("url", url);
        return this;
    }

    public Product setVariation(String variation) {
        data.put("Variation", variation);
        return this;
    }
}
