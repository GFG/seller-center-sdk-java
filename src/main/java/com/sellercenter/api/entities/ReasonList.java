package com.sellercenter.api.entities;

import com.sellercenter.api.core.response.SuccessResponse;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReasonList implements Iterable<Reason> {
    private final List<Reason> reasons = new LinkedList<>();

    ReasonList(SuccessResponse response) {
        JsonObject body = response.getBody();
        JsonValue reason = body.getJsonObject("Reasons").get("Reason");
        if (reason instanceof JsonObject) {
            reasons.add(new Reason((JsonObject) reason));
        } else if (reason instanceof JsonArray) {
            for (JsonValue r : (JsonArray) reason) {
                if (r instanceof JsonObject) {
                    reasons.add(new Reason((JsonObject) r));
                }
            }
        }
    }

    @Override
    public Iterator<Reason> iterator() {
        return reasons.iterator();
    }
}
