package com.sellercenter.api.entities;

import com.sellercenter.api.exceptions.ResponseDataException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;

public class Attribute extends AbstractModel {

    private final Collection<AttributeOption> options = new ArrayList<>();

    /**
     *
     * @param data
     */
    Attribute(JsonObject data) throws ResponseDataException {
        super(data);

        if (data.get("Options") == null) {
            throw new ResponseDataException("Cannot create attribute");
        }

        if (data.get("Options") instanceof JsonObject) {
            JsonValue option = data.getJsonObject("Options").get("Option");

            if (option == null) {
                throw new ResponseDataException("Cannot create attribute");
            }

            if (option instanceof JsonArray) {
                for (JsonValue opt : (JsonArray) option) {
                    if (opt instanceof JsonObject) {
                        options.add(new AttributeOption((JsonObject) opt));
                    }
                }
            } else if (option instanceof JsonObject) {
                options.add(new AttributeOption((JsonObject) option));
            }
        }
    }

    /**
     * States if this attribute is mandatory
     * @return true if attribute is mandatory
     */
    public boolean isMandatory() {
        return this.getInt("isMandatory") != 0;
    }

    /**
     * Return the identifier of the attribute that must be used
     * in product changes when interacting with Seller Center
     *
     * @return identifier of the attribute
     */
    public String getIdentifier() {
        return data.getString("Name");
    }
    /**
     * Returns the options of the attribute.
     * The set is empty if no options are required.
     *
     * @return options of the attribute
     */
    public Collection<AttributeOption> getOptions() {
        return options;
    }

    /**
     *
     * @return
     */
    public boolean hasOptions() {
        return !this.options.isEmpty();
    }

}
