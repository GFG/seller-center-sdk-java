package com.sellercenter.api.entities;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;

public class Attribute extends AbstractModel {

    private final Collection<AttributeOption> options = new ArrayList<>();

    /**
     *
     * @param data
     */
    Attribute(JsonObject data) {
        super(data);

        JsonObject option = data.getJsonObject("Options").getJsonObject("Option");

        if (option instanceof JsonArray) {
            for (JsonValue opt : (JsonArray) option) {
                if (opt instanceof JsonObject) {
                    options.add(new AttributeOption((JsonObject) opt));
                }
            }
        }
    }

    /**
     * States if this attribute is mandatory
     * @return true if attribute is mandatory
     */
    public boolean isMandatory() {
        return data.getInt("isMandatory") == 0;
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
