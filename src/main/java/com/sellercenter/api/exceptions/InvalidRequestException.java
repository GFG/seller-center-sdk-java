package com.sellercenter.api.exceptions;

public class InvalidRequestException extends ApiException {
    public InvalidRequestException(String msg) {
        super(msg);
    }
}
