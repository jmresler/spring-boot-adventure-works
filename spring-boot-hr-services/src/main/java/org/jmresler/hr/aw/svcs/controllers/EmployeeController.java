package org.jmresler.hr.aw.svcs.controllers;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.svcs.domain.Employee;
import org.jmresler.hr.aw.svcs.services.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Api
@Slf4j
@RestController
@RequestMapping(path = EmployeeController.PATH)
public class EmployeeController {

    public static final String PATH = "/employee";

    @Autowired
    protected EmployeeManagementService employeeManagementService;

    @GetMapping(path = "/get-by-id/{id}",
            consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE},
            produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") final Integer id) {
        log.debug("received id {} in getEmployeeById", id);
        return null;
    }
}
