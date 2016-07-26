package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.exceptions.SdkException;
import com.rocketlabs.sellercenterapi.exceptions.ResponseDataException;

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
