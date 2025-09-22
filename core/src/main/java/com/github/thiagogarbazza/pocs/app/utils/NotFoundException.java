package com.github.thiagogarbazza.pocs.app.utils;

public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(message);
    }

    public static NotFoundException of(final String message) {
        return new NotFoundException(message);
    }
}
