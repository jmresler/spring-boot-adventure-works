package org.jmresler.hr.micro.controllers;


import org.jmresler.hr.micro.services.IllegalPageSizeException;
import org.jmresler.hr.micro.services.NoEmployeeViewException;
import org.jmresler.hr.micro.services.NoSuchPageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static java.time.LocalDateTime.now;



@ControllerAdvice
public class EmployeeViewControllerAdvice {

    @ExceptionHandler(NoEmployeeViewException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException( NoEmployeeViewException ex, WebRequest request) {
        var body = new LinkedHashMap<String, Object>();
        body.put("timestamp", now());
        body.put("message", "Employee Not Found");
        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(NoSuchPageException.class)
    public ResponseEntity<Object> handleBadPageRequest(NoSuchPageException exception, WebRequest request) {
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
