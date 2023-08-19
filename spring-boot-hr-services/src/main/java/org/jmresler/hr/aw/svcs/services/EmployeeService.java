package org.jmresler.hr.aw.svcs.services;

import org.jmresler.hr.aw.svcs.domain.Employee;
import org.jmresler.hr.aw.svcs.domain.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    protected EmployeeRepository employeeRepository;

    public Employee getEmployeeById(final Integer id) {

        return null;
    }

    public void saveEmployee(final Employee employee) {

    }
}
