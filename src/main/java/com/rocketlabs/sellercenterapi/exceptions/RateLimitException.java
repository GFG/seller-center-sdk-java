package com.rocketlabs.sellercenterapi.exceptions;

public class RateLimitException extends ApiException {
    public RateLimitException(String message) {
        super(message);
    }
}
