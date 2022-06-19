package org.jmresler.hr.aw.views.svcs.services;

public class NoSuchPageException extends RuntimeException {

    public NoSuchPageException() {
        super();
    }

    public NoSuchPageException(String message) {
        super(message);
    }

    public NoSuchPageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchPageException(Throwable cause) {
        super(cause);
    }

    protected NoSuchPageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
