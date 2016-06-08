package com.rocketlabs.sellercenterapi.exceptions;

public class SdkException extends Exception {
    public SdkException(String message) {
        super(message);
    }

    public SdkException(String message, Throwable cause) {
        super(message, cause);
    }
}
