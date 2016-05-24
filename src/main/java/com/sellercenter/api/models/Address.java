package com.sellercenter.api.models;

import com.sellercenter.api.core.response.AbstractModel;

import java.util.Map;

/**
 * Model for addresses
 * Provide getters and setters to all attributes
 */
public class Address extends AbstractModel {

    public Address(Map<String, Object> body) {
        super(body);
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

    public Address setFirstName(String firstName) {
        this.data.put("FirstName", firstName);
        return this;
    }

    public Address setLastName(String lastName) {
        this.data.put("LastName", lastName);
        return this;
    }

    public Address setPhone(String phone) {
        this.data.put("Phone", phone);
        return this;
    }

    public Address setPhone2(String phone2) {
        this.data.put("Phone2", phone2);
        return this;
    }

    public Address setAddress1(String address1) {
        this.data.put("Address1", address1);
        return this;
    }

    public Address setAddress2(String address2) {
        this.data.put("Address2", address2);
        return this;
    }

    public Address setAddress3(String address3) {
        this.data.put("Address3", address3);
        return this;
    }

    public Address setAddress4(String address4) {
        this.data.put("Address4", address4);
        return this;
    }

    public Address setAddress5(String address5) {
        this.data.put("Address5", address5);
        return this;
    }

    public Address setCity(String city) {
        this.data.put("City", city);
        return this;
    }

    public Address setWard(String ward) {
        this.data.put("Ward", ward);
        return this;
    }

    public Address setRegion(String region) {
        this.data.put("Region", region);
        return this;
    }

    public Address setPostCode(String postCode) {
        this.data.put("PostCode", postCode);
        return this;
    }

    public Address setCountry(String country) {
        this.data.put("Country", country);
        return this;
    }
}
