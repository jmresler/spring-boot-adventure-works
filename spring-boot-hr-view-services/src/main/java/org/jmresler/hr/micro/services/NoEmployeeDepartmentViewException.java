package org.jmresler.hr.micro.services;

public class NoEmployeeDepartmentViewException extends RuntimeException {

    public NoEmployeeDepartmentViewException() {
        super();
    }

    public NoEmployeeDepartmentViewException(String message) {
        super(message);
    }

    public NoEmployeeDepartmentViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEmployeeDepartmentViewException(Throwable cause) {
        super(cause);
    }

    protected NoEmployeeDepartmentViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
