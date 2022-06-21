package org.jmresler.hr.aw.views.svcs.services;

public class NoJobCandidateViewException extends RuntimeException {

    public NoJobCandidateViewException() {
        super();
    }

    public NoJobCandidateViewException(String message) {
        super(message);
    }

    public NoJobCandidateViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoJobCandidateViewException(Throwable cause) {
        super(cause);
    }

    protected NoJobCandidateViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
