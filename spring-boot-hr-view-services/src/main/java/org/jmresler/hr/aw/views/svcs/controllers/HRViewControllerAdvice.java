package org.jmresler.hr.aw.views.svcs.controllers;


import org.jmresler.hr.aw.views.svcs.services.IllegalPageSizeException;
import org.jmresler.hr.aw.views.svcs.services.NoEmployeeViewException;
import org.jmresler.hr.aw.views.svcs.services.NoJobCandidateViewException;
import org.jmresler.hr.aw.views.svcs.services.NoSuchPageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@ControllerAdvice
public class HRViewControllerAdvice {

    @ExceptionHandler(NoEmployeeViewException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(final NoEmployeeViewException ex, final WebRequest request) {
        var body = new LinkedHashMap<String, Object>();
        body.put("timestamp", now());
        body.put("message", "Employee Not Found");
        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(NoJobCandidateViewException.class)
    public ResponseEntity<Object> handleCandidateNotFoundException(final NoJobCandidateViewException ex, final WebRequest request) {
        var body = new LinkedHashMap<String, Object>();
        body.put("timestamp", now());
        body.put("message", "Candidate Not Found");
        return new ResponseEntity<>(body, NOT_FOUND);
    }


    @ExceptionHandler(NoSuchPageException.class)
    public ResponseEntity<Object> handleBadPageRequest(final NoSuchPageException exception, final WebRequest request) {
        var body = new LinkedHashMap<String, Object>();
        body.put("timestamp", now());
        body.put("message", "Page number does not exist");
        return new ResponseEntity<>(body, BAD_REQUEST);
    }

    @ExceptionHandler(IllegalPageSizeException.class)
    public ResponseEntity<Object> handleBadPageSizeRequests(IllegalPageSizeException exception, WebRequest request) {
        var body = new LinkedHashMap<String, Object>();
        body.put("timestamp", now());
        body.put("message", "Illegal requested page size");
        return new ResponseEntity<>(body, BAD_REQUEST);
    }

}
