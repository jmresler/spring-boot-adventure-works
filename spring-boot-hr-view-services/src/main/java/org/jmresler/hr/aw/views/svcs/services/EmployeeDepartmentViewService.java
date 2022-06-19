package org.jmresler.hr.aw.views.svcs.services;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.views.svcs.dto.EmployeeDepartmentViewList;
import org.jmresler.hr.aw.views.svcs.domain.VEmployeeDepartment;
import org.jmresler.hr.aw.views.svcs.domain.repo.VEmployeeDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EmployeeDepartmentViewService {

    private static final int MIN_PAGE_NO = 0;
    private static final int MIN_PAGE_SIZE = 1;

    @Autowired
    protected VEmployeeDepartmentRepository repository;


    public VEmployeeDepartment getEmployeeDepartmentById(final Integer id) {
        Optional<VEmployeeDepartment> optionalEmpDep = repository.findById(id);
        return optionalEmpDep.orElseThrow(NoEmployeeDepartmentViewException::new);
    }

    public EmployeeDepartmentViewList getEmployeeDepartmentViewPage(final int pageNo, final int pageSize) {
        checkPageNoAndSize(pageNo, pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc("businessEntityID")));
        var employeeDepts = repository.findAll(pageable).toList();
        var empDeptViewList = new EmployeeDepartmentViewList();
        empDeptViewList.setEmployeeDepartmentList(employeeDepts);
        return empDeptViewList;
    }

    public EmployeeDepartmentViewList getEmployeeDepartmentViewsPage(final String department, final int pageNo, final int pageSize) {
        checkPageNoAndSize(pageNo, pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc("businessEntityID")));
        var employeeDepts = repository.findByDepartment(department, pageable).toList();
        var empDeptViewList = new EmployeeDepartmentViewList();
        empDeptViewList.setEmployeeDepartmentList(employeeDepts);
        return empDeptViewList;
    }

    public EmployeeDepartmentViewList getEmployeeDepartmentViewsByEmpNamePage(final String firstName, final String lastName, final int pageNo, final int pageSize) {
        checkPageNoAndSize(pageNo, pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc("businessEntityID")));
        var employees = repository.findByFirstNameAndLastName(firstName, lastName, pageable).toList();
        var empDeptViewList = new EmployeeDepartmentViewList();
        empDeptViewList.setEmployeeDepartmentList(employees);
        return empDeptViewList;
    }


    private void checkPageNoAndSize(int pageNo, int pageSize) {
        if (pageNo < MIN_PAGE_NO)
            throw new NoSuchPageException();

        if (pageSize < MIN_PAGE_SIZE)
            throw new IllegalPageSizeException();

    }
}
