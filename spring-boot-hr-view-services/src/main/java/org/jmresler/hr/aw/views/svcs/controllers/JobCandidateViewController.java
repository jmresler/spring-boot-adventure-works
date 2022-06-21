package org.jmresler.hr.aw.views.svcs.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.views.svcs.domain.VJobCandidate;
import org.jmresler.hr.aw.views.svcs.services.JobCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Api("Retrieve Job Candidate View Items")
@Slf4j
@RestController
@RequestMapping(path = JobCandidateViewController.PATH)
public class JobCandidateViewController {
    public static final String PATH = "/job-candidate";

    @Autowired
    protected JobCandidateService service;

    @ApiOperation(value = "Retrieves a job candidate view by ID",
            consumes = "application/json, application/xml",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            protocols = "HTTP, HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Retrieved"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Job Candidate View Not Found"),
            @ApiResponse(code = 415, message = "Invalid content-type, Expected 'application/json' or 'application/xml' content type"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(path = "/get-candidate-by-id/{id}",
                headers = {"id-claim"},
                produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
                consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<VJobCandidate> getCandidateById(@PathVariable("id") final Integer id) {
        log.info("received id parameter {}", id);
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

}
