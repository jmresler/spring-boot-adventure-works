package org.jmresler.hr.aw.views.svcs.services;

public class IllegalPageSizeException extends RuntimeException{

    public IllegalPageSizeException() {
        super();
    }

    public IllegalPageSizeException(String message) {
        super(message);
    }

    public IllegalPageSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalPageSizeException(Throwable cause) {
        super(cause);
    }

    protected IllegalPageSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
