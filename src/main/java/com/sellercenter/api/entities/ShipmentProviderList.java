package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShipmentProviderList implements Iterable<ShipmentProvider> {
    private final List<ShipmentProvider> shipmentProviders = new LinkedList<>();

    ShipmentProviderList(SuccessResponse response) {
        JsonObject body = response.getBody();
        JsonValue reason = body.getJsonObject("ShipmentProviders").get("ShipmentProvider");
        if (reason instanceof JsonObject) {
            shipmentProviders.add(new ShipmentProvider((JsonObject) reason));
        } else if (reason instanceof JsonArray) {
            for (JsonValue r : (JsonArray) reason) {
                if (r instanceof JsonObject) {
                    shipmentProviders.add(new ShipmentProvider((JsonObject) r));
                }
            }
        }
    }

    @Override
    public Iterator<ShipmentProvider> iterator() {
        return shipmentProviders.iterator();
    }
}
