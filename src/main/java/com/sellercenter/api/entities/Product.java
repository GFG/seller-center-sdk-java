package com.sellercenter.api.entities;

import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    /**
     * Map containing data for updates
     * Should never be set to null, only cleared
     */
    private Map<String, Object> updateAttributes = new HashMap<>();

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
        updateAttributes.clear();
        updateAttributes.putAll(attributes);
    }

    /**
     * Request an update of the attributes that were set with 'setNewAttributes'
     * Clear the attributes after the API process.
     *
     * @throws SdkException
     */
    public void update() throws SdkException {
        repository.update(this);
    }

    /**
     * Predicate to test if products can be updated
     *
     * @return true if new attributes were set
     */
    boolean hasNewAttributes() {
        return updateAttributes.isEmpty();
    }

    /**
     * Return the new attributes of the product if they were set.
     * Also include SellerSku to identify the product.
     * Clear the attributes of the instance.
     *
     * @return Map associating attributes to their new value
     */
    Map<String, Object> retrieveNewAttributes() {
        Map<String, Object> attributes = new HashMap<>(updateAttributes);
        attributes.put("SellerSku", getString("SellerSku"));
        updateAttributes.clear();
        return attributes;
    }

    public List<String> getImages() {
        return imageList;
    }

    public ProductData getProductData() {
        return productData;
    }
}
