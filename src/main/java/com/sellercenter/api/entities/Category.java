package com.sellercenter.api.entities;

import com.sellercenter.api.exceptions.ResponseDataException;
import com.sellercenter.api.exceptions.SdkException;

import javax.json.JsonObject;
import java.util.Collection;

public class Category extends AbstractModel {

    private Collection<Category> children;
    private ProductRepository repository = new ProductRepository();

    Category(JsonObject data) throws ResponseDataException {
        super(data);
        if (data.get("Children") == null) {
            throw new ResponseDataException("Can't create category");
        }
        this.children = Factory.createCategoryCollection(data.get("Children"));
    }

    public Collection<Category> getChildren() {
        return this.children;
    }

    public Collection<Attribute> getAttributes() throws SdkException {
        return this.repository.getCategoryAttributes(this);
    }
}
