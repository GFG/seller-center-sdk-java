package com.sellercenter.api.entities;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Model for Product
 * Provide getters and setters to all mandatory attributes
 */
public final class Product extends AbstractModel {

    /**
     * List of image URIs
     */
    private final List<String> imageList;

    /**
     * product data
     */
    private final ProductData productData;

    /**
     * dedicated repository
     */
    private ProductRepository repository = new ProductRepository();
    private Map<String, Object> updateAttributes = null;

    /**
     * Constructor
     *
     * @param data Json load from response body
     */
    Product(JsonObject data) {
        super(data);

        this.imageList = new LinkedList<>();

        if (data.get("Images") instanceof JsonObject) {
            JsonValue imageData = data.getJsonObject("Images").get("Image");
            if (imageData instanceof JsonArray) {
                for (JsonValue img : (JsonArray) imageData) {
                    imageList.add(img.toString());
                }
            } else {
                imageList.add(imageData.toString());
            }
        }
        this.productData = new ProductData(data.getJsonObject("ProductData"));
    }

    /**
     * Set a map of attributes to be updated.
     * Changes will not be requested until 'update' is called.
     *
     * @param attributes A map associating attributes with their new requested value.
     */
    public void setNewAttributes(Map<String, Object> attributes) {
        this.updateAttributes = new HashMap<>(attributes);
    }

    /**
     * Request an update of the attributes that were set with 'setNewAttributes'
     * Clear the attributes after the API process.
     *
     * @throws SdkException
     */
    public void update() throws SdkException {
        this.repository.update(this);
    }

    /**
     * Predicate to test if new attributes were set
     *
     * @return true if new attributes were set
     */
    boolean hasNewAttributes() {
        return this.updateAttributes != null;
    }

    /**
     * Return the new attributes of the product if they were set.
     * Also include SellerSku to identify the product.
     * Clear the attributes of the instance.
     *
     * If no attributes were set, throw an exception.
     *
     * @return Map associating attributes to their new value
     * @throws SdkException
     */
    Map<String, Object> retrieveNewAttributes() throws SdkException {
        if (!hasNewAttributes()) {
            throw new SdkException("Product update : No new attributes were set for update");
        }
        Map<String, Object> attributes = this.updateAttributes;
        attributes.put("SellerSku", getString("SellerSku"));
        this.updateAttributes = null;
        return attributes;
    }
    public List<String> getImages() {
        return imageList;
    }

    public ProductData getProductData() {
        return productData;
    }
}
