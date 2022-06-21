package org.jmresler.hr.aw.views.svcs.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.views.svcs.domain.VEmployee;
import org.jmresler.hr.aw.views.svcs.dto.EmployeeViewList;
import org.jmresler.hr.aw.views.svcs.services.EmployeeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Api("Retrieve Employee View Items")
@Slf4j
@RequestMapping(EmployeeViewController.PATH)
@RestController
public class EmployeeViewController {
    public static final String PATH = "/employee";

    @Autowired
    protected EmployeeViewService viewService;

    @ApiOperation(value = "Retrieves Employee View by ID '/get-employee/{id}'",
            consumes = "application/json, application/xml",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            protocols = "HTTP, HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Retrieved"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Employee View Not Found"),
            @ApiResponse(code = 415, message = "Invalid content-type, Expected 'application/json' or 'application/xml' content type"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(path = "/get-employee/{id}",
            headers = {"id-claim"},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<VEmployee> getEmployeeView(final @PathVariable("id") Integer employeeId) {
        var employeeView = viewService.getEmployeeViewById(employeeId);
        return new ResponseEntity<>(employeeView, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves employee views by requested page number and page size '/get-emp-by-page/{pageNo}/{pageSize}'",
            consumes = "application/json, application/xml",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            protocols = "HTTP, HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Retrieved"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Employee Views Not Found"),
            @ApiResponse(code = 415, message = "Invalid content-type, Expected 'application/json' or 'application/xml' content type"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(path = "/get-emp-by-page/{pageNo}/{pageSize}",
            headers = {"id-claim"},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeViewList> getEmployeeViewsByPage(
            @ApiParam(name = "pageNo",
                    allowEmptyValue = false,
                    allowMultiple = false,
                    type = "java.lang.Integer >= 0")
            @PathVariable("pageNo") final int pageNo,
            @ApiParam(name = "pageSize",
                    allowEmptyValue = false,
                    allowMultiple = false,
                    type = "java.lang.Integer >= 0")
            @PathVariable("pageSize") final int pageSize) {
            var employees = viewService.getEmployeeViewByPage(pageNo, pageSize);
            var employeeViewList = new EmployeeViewList();
            employeeViewList.setEmployeeViewList(employees);
        return new ResponseEntity<>(employeeViewList, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves employee views by requested page number, page size, employee first name and employee last name '/get-emp-by-page/{pageNo}/{pageSize}'",
            consumes = "application/json, application/xml",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            protocols = "HTTP, HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfuly Retrieved"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Employee Views Not Found"),
            @ApiResponse(code = 415, message = "Invalid content-type, Expected 'application/json' or 'application/xml' content type"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(path = "/get-emp-by-names-page/{pageNo}/{pageSize}",
            headers = {"id-claim"},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeViewList> getEmployeeViewsByFirstNameLastName(
            @ApiParam(name = "pageNo",
                    allowEmptyValue = false,
                    allowMultiple = false,
                    type = "java.lang.Integer >= 0")
            @PathVariable("pageNo") final int pageNo,
            @ApiParam(name = "pageSize",
                    allowEmptyValue = false,
                    allowMultiple = false,
                    type = "java.lang.Integer >= 0")
            @PathVariable("pageSize") final int pageSize,
            @Param("firstName") final String firstName,
            @Param("lastName") final String lastName) {

        var employees = viewService.getEmployeeViewByFirstNameLastName(pageNo, pageSize, firstName, lastName);
        var employeeViewList = new EmployeeViewList();
        employeeViewList.setEmployeeViewList(employees);
        return new ResponseEntity<>(employeeViewList, HttpStatus.OK);
    }
}
