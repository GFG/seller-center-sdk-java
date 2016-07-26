package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShipmentProviderCollection implements Iterable<ShipmentProvider> {
    private final List<ShipmentProvider> shipmentProviders = new LinkedList<>();

    ShipmentProviderCollection(SuccessResponse response) {
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
