package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

import java.util.*;

class ProductRepository extends AbstractRepository {

    /**
     * Perform api call to get a list of products
     * under the options constraint
     *
     * @param options optional request parameters
     * @return list of all or a range of products
     * @throws SdkException
     */
    ProductCollection retrieve(GetProductsOptions options) throws SdkException {
        SuccessResponse response = requestApi("GetProducts", options.toMap());

        return new ProductCollection(response);
    }

    void update(Product product) throws SdkException {
        Map<String, Object> attributes = product.retrieveNewAttributes();

        Map<String, Object> body = new HashMap<>();
        body.put("Product", attributes);

        Map<String, String> params = new HashMap<>();

        requestApi("UpdateProducts", params, body);
    }

    void update(Collection<Product> products) throws SdkException {
        List<Map> updateList = new LinkedList<>();
        for (Product product : products) {
            if (product.hasNewAttributes()) {
                updateList.add(product.retrieveNewAttributes());
            }
        }

        Map<String, Object> body = new HashMap<>();
        body.put("Product", updateList);

        Map<String, String> params = new HashMap<>();

        requestApi("UpdateProducts", params, body);
    }

    Collection<Attribute> getCategoryAttributes(Category category) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("PrimaryCategory", category.getString("CategoryId"));
        return Factory.createAttributeCollection(
                requestApi("GetCategoryAttributes", params)
        );
    }

    Collection<Category> getCategoryTree() throws SdkException {
        return Factory.createCategoryCollection(requestApi("GetCategoryTree"));
    }

    void createProduct(List<Map> products) throws SdkException {
        Map<String, Object> body = new HashMap<>();
        body.put("Product", products);

        requestApi("ProductCreate", new HashMap<String, String>(), body);
    }
}
