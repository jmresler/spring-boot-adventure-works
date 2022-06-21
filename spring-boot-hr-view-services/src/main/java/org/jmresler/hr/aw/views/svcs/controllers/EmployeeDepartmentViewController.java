package org.jmresler.hr.aw.views.svcs.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.views.svcs.domain.VEmployeeDepartment;
import org.jmresler.hr.aw.views.svcs.dto.EmployeeDepartmentViewList;
import org.jmresler.hr.aw.views.svcs.services.EmployeeDepartmentViewService;
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


@ApiOperation("Retrieve Employee Department View Items")
@Slf4j
@RestController
@RequestMapping(path = EmployeeDepartmentViewController.PATH)
public class EmployeeDepartmentViewController {

    public static final String PATH = "/emp-dept-view";

    @Autowired
    protected EmployeeDepartmentViewService service;

    @ApiOperation(value = "Retrieves an employee department view by ID",
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
    @GetMapping(path = "/get-emp-dept/{id}",
            headers = {"id-claim"},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<VEmployeeDepartment> getEmployeeDepartmentViewById(final @PathVariable("id") Integer employeeId) {
        return new ResponseEntity<>(service.getEmployeeDepartmentById(employeeId), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves employee department views by requested page number and page size",
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
    public ResponseEntity<EmployeeDepartmentViewList> getEmployeeDepartmentViewsByPage(
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

        var empDeptList = service.getEmployeeDepartmentViewPage(pageNo, pageSize);
        return new ResponseEntity<>(empDeptList, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves employee department views by requested page number, page size, employee first and last name",
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
    @GetMapping(path = "/get-emp-dept-by-names-page/{pageNo}/{pageSize}",
            headers = {"id-claim"},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeDepartmentViewList> getEmployeeDepartmentViewsByFirstNameLastName(
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
        var empDeptViewList = service.getEmployeeDepartmentViewsByEmpNamePage(firstName, lastName, pageNo, pageSize);
        return new ResponseEntity<>(empDeptViewList,  HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves employee department views by requested page number, page size and department name",
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
    @GetMapping(path = "/get-emp-dept-by-dept-page/{department}/{pageNo}/{pageSize}",
            headers = {"id-claim"},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeDepartmentViewList> getEmployeeDepartmentViewsByDepartment(
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
            @ApiParam(name = "department",
                    allowEmptyValue = false,
                    allowMultiple = false,
                    type = "java.lang.String")
            @PathVariable("department") final String department) {
        var employees = service.getEmployeeDepartmentViewsPage(department, pageNo, pageSize).getEmployeeDepartmentList();
        var employeeDeptList = new EmployeeDepartmentViewList();
        employeeDeptList.setEmployeeDepartmentList(employees);
        return new ResponseEntity<>(employeeDeptList, HttpStatus.OK);
    }
}
