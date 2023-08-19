package org.jmresler.hr.aw.svcs.services;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.svcs.domain.Department;
import org.jmresler.hr.aw.svcs.domain.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentService {

    @Autowired
    protected DepartmentRepository repository;

    public Department getById(final Short id) {
        return repository.findById(id).orElse(Department.EMPTY_DEPARTMENT);
    }

}
