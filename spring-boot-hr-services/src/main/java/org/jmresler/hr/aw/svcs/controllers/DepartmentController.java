package org.jmresler.hr.aw.svcs.controllers;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.svcs.domain.Department;
import org.jmresler.hr.aw.svcs.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(path = DepartmentController.PATH)
@RestController
public class DepartmentController {

    public static final String PATH = "/dept";

    @Autowired
    protected DepartmentService service;

    @GetMapping(path = "/get-by-id/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getById(@PathVariable("id") Short id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
