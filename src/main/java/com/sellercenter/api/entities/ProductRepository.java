package com.sellercenter.api.entities;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.exceptions.SdkException;

import java.util.*;

class ProductRepository {

    /**
     * Perform api call to get a list of products
     * under the options constraint
     *
     * @param options optional request parameters
     * @return list of all or a range of products
     * @throws SdkException
     */
    ProductList retrieve(GetProductsOptions options) throws SdkException {
        SuccessResponse response = Client.call(
                new Request(
                        "GetProducts",
                        SellerCenter.userId,
                        SellerCenter.apiKey,
                        SellerCenter.version,
                        options.toMap()
                )
        );

        return new ProductList(response);
    }

    void update(Product product) throws SdkException {
        Map<String, Object> attributes = product.retrieveNewAttributes();

        Map<String, Object> body = new HashMap<>();
        body.put("Product", attributes);

        Map<String, String> params = new HashMap<>();

        Client.call(
                new Request(
                        "UpdateProducts",
                        SellerCenter.userId,
                        SellerCenter.apiKey,
                        SellerCenter.version,
                        params,
                        body
                )
        );
    }

    void update(List<Product> products) throws SdkException {
        List<Map> updateList = new LinkedList<>();
        for (Product product : products) {
            if (product.hasNewAttributes()) {
                updateList.add(product.retrieveNewAttributes());
            }
        }

        Map<String, Object> body = new HashMap<>();
        body.put("Product", updateList);

        Map<String, String> params = new HashMap<>();

        Client.call(
                new Request(
                        "UpdateProducts",
                        SellerCenter.userId,
                        SellerCenter.apiKey,
                        SellerCenter.version,
                        params,
                        body
                )
        );
    }

    Collection<Attribute> getCategoryAttributes(Category category) throws SdkException {
        Map<String, String> params = new HashMap<>();
        params.put("PrimaryCategory", category.getString("CategoryId"));
        return Factory.createAttributeCollection(Client.call(
                new Request(
                        "GetCategoryAttributes",
                        SellerCenter.userId,
                        SellerCenter.apiKey,
                        SellerCenter.version,
                        params
                )
        ));
    }

    Collection<Category> getCategoryTree() throws SdkException {
        return Factory.createCategoryCollection(Client.call(
                new Request(
                        "GetCategoryTree",
                        SellerCenter.userId,
                        SellerCenter.apiKey,
                        SellerCenter.version
                )
        ));
    }

    void createProduct(List<Map> products) throws SdkException {
        Map<String, Object> body = new HashMap<>();
        body.put("Product", products);

        Client.call(
                new Request(
                        "ProductCreate",
                        SellerCenter.userId,
                        SellerCenter.apiKey,
                        SellerCenter.version,
                        new HashMap<String, String>(),
                        body
                )
        );
    }
}
