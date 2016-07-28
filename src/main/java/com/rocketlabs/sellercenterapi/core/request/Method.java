package com.rocketlabs.sellercenterapi.core.request;

public enum Method {
    GET,
    POST;

    @Override
    public String toString() {
        switch (this) {
            case GET:
                return com.jcabi.http.Request.GET;
            case POST:
                return com.jcabi.http.Request.POST;
        }
        return null;
    }
}
