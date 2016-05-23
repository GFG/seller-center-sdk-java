package com.sellercenter.api.core.request;

public enum Method {
    GET, POST;

    @Override
    public String toString() {
        switch (this) {
            case GET: return "GET";
            case POST: return "POST";
            default: return null;
        }
    }
}
