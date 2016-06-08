package com.sellercenter.api.entities;

import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
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
     * false if already exists in SC
     */
    private boolean isNew = true;

    /**
     * dedicated repository
     */
    private ProductRepository repository = new ProductRepository();

    /**
     * Constructor
     *
     * @param data Json load from response body
     */
    Product(JsonObject data) {
        super(data);
        this.isNew = false;

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
     * Save the product to seller center
     *
     * @throws SdkException
     */
    public void save() throws SdkException {
        this.repository.persist(this);
    }

    @Override
    public Map<String, Object> toMap() {
        //@Todo: generate map with variations, or updated values
        return super.toMap();
    }

    public boolean isNew() {
        return this.isNew;
    }

    public List<String> getImages() {
        return imageList;
    }

    public ProductData getProductData() {
        return productData;
    }
}
