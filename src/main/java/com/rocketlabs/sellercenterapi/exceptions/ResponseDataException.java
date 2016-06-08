package com.rocketlabs.sellercenterapi.exceptions;

public class ResponseDataException extends SdkException{
    public ResponseDataException(String prefix) {
        super(prefix + " : data retrieved from response is incomplete or erroneous" );
    }
}

