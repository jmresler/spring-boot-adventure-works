package org.jmresler.hr.aw.svcs.services;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.svcs.domain.Employee;
import org.jmresler.hr.aw.svcs.domain.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeManagementService {

    @Autowired
    protected EmployeeRepository employeeRepository;

    public Employee getEmployeeById(final Integer id) {
        log.debug("recieved id {} in getEmployeeById", id);
        return null;
    }

    public void saveEmployee(final Employee employee) {

    }
}
