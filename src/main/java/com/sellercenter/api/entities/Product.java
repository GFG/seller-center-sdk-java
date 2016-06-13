package com.sellercenter.api.entities;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
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

    public List<String> getImages() {
        return imageList;
    }

    public ProductData getProductData() {
        return productData;
    }
}
