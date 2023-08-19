package org.jmresler.hr.aw.svcs.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.jmresler.hr.aw.svcs.domain.Employee;
import org.jmresler.hr.aw.svcs.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api
@Slf4j
@RestController
@RequestMapping(path = EmployeeController.PATH)
public class EmployeeController {

    public static final String PATH = "/employee";

    @Autowired
    protected EmployeeService employeeService;

    @GetMapping(path = "/get-by-id/{id}",
            consumes = {APPLICATION_JSON_VALUE},
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") final Integer id) {
        var response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }
}
