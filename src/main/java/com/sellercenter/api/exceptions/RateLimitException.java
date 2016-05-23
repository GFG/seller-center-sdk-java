package com.sellercenter.api.exceptions;

public class RateLimitException extends ApiException {
    public RateLimitException(String message) {
        super(message);
    }
}
