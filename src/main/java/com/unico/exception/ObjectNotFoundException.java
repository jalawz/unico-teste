package com.unico.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException (final String msg) {
        super(msg);
    }

    public ObjectNotFoundException (final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
