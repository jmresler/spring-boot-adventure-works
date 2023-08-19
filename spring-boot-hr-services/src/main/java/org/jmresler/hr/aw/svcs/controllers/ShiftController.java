package org.jmresler.hr.aw.svcs.controllers;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.jmresler.hr.aw.svcs.domain.Shift;
import org.jmresler.hr.aw.svcs.services.ShiftService;
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
@RequestMapping(path = ShiftController.PATH)
public class ShiftController {

    public static final String PATH = "/shift";

    @Autowired
    protected ShiftService service;

    @GetMapping(path = "/get-shift-id/{id}",
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<Shift> getShiftById(@PathVariable("id") final Short id) {
        return null;
    }
}
