package org.jmresler.hr.micro.services;

import java.security.PrivilegedActionException;

public class NoEmployeeViewException extends RuntimeException {

    public NoEmployeeViewException() {
        super();
    }

    public NoEmployeeViewException(String message) {
        super(message);
    }

    public NoEmployeeViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEmployeeViewException(Throwable cause) {
        super(cause);
    }

    protected NoEmployeeViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
