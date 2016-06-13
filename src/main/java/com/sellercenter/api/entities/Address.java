package com.sellercenter.api.entities;

import javax.json.JsonObject;

/**
 * Model for addresses
 * Provide getters and setters to all attributes
 */
public final class Address extends AbstractModel {

    /**
     * Constructor
     *
     * @param data Json load from response body
     */
    public Address(JsonObject data) {
        super(data);
    }

    public String getFirstName() {
        return getString("FirstName");
    }

    public String getLastName() {
        return getString("LastName");
    }

    public String getPhone() {
        return getString("Phone");
    }

    public String getPhone2() {
        return getString("Phone2");
    }

    public String getAddress1() {
        return getString("Address1");
    }

    public String getAddress2() {
        return getString("Address2");
    }

    public String getAddress3() {
        return getString("Address3");
    }

    public String getAddress4() {
        return getString("Address4");
    }

    public String getAddress5() {
        return getString("Address5");
    }

    public String getCity() {
        return getString("City");
    }

    public String getWard() {
        return getString("Ward");
    }

    public String getRegion() {
        return getString("Region");
    }

    public String getPostCode() {
        return getString("PostCode");
    }

    public String getCountry() {
        return getString("Country");
    }
}
