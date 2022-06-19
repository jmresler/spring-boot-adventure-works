package org.jmresler.hr.micro.services;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.micro.domain.VEmployee;
import org.jmresler.hr.micro.domain.repo.VEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles retrieval and manipulation of employee view objects
 *
 * @author John M. Resler
 * @version 1.0
 */
@Slf4j
@Service
public class EmployeeViewService {

    private static final int MIN_PAGE_NO = 0;
    private static final int MIN_PAGE_SIZE = 1;

    @Autowired
    protected VEmployeeRepository vEmployeeRepository;

    public VEmployee getEmployeeViewById(final Integer id) {
        return vEmployeeRepository.findById(id).orElseThrow(NoEmployeeViewException::new);
    }

    public List<VEmployee> getEmployeeViewByPage(int pageNo, int pageSize) {
        checkPageNoAndSize(pageNo, pageSize);

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc("businessEntityID")));
        var employees = vEmployeeRepository.findAll(pageable).toList();
        employees = employees.stream().map(e -> removeNulls(e)).collect(Collectors.toList());

        return employees;
    }

    public List<VEmployee> getEmployeeViewByFirstNameLastName(
            int pageNo,
            int pageSize,
            final String firstName,
            final String lastName) {

        checkPageNoAndSize(pageNo, pageSize);

        var pageable = PageRequest.of(pageNo, pageSize, Sort.by("lastName", "firstName"));
        var employeeList = vEmployeeRepository.findByFirstNameAndLastName(firstName, lastName, pageable).toList();

        return employeeList;
    }

    public VEmployee findEmployeeByEmailAddress(final String emailAddress) {
        var employee = vEmployeeRepository.findByEmailAddress(emailAddress).map(emp -> removeNulls(emp)).orElseThrow(NoEmployeeViewException::new);
        return employee;
    }

    /*
     * Normally you would not do something like this in the middle tier.
     * This is really UI logic but we'll leave it here as a placeholder
     * to simulate processing
     *
     * @param employeeView
     * @return
     */
    private VEmployee removeNulls(final VEmployee employeeView) {
        if (employeeView.getJobTitle() == null)
            employeeView.setJobTitle("");
        if (employeeView.getMiddleName() == null)
            employeeView.setMiddleName("");
        if (employeeView.getLastName() == null)
            employeeView.setLastName("");
        if (employeeView.getAdditionalContactInfo() == null)
            employeeView.setAdditionalContactInfo("");
        if (employeeView.getTitle() == null)
            employeeView.setTitle("");
        if (employeeView.getAddressLine1() == null)
            employeeView.setAddressLine1("");
        if (employeeView.getAddressLine2() == null)
            employeeView.setAddressLine2("");
        if (employeeView.getSuffix() == null)
            employeeView.setSuffix("");
        if (employeeView.getCity() == null)
            employeeView.setCity("");
        if (employeeView.getStateProvinceName() == null)
            employeeView.setStateProvinceName("");
        if (employeeView.getCountryRegionName() == null)
            employeeView.setCountryRegionName("");
        if (employeeView.getEmailAddress() == null)
            employeeView.setEmailAddress("");
        if (employeeView.getPhoneNumber() == null)
            employeeView.setPhoneNumber("");
        if (employeeView.getPhoneNumberType() == null)
            employeeView.setPhoneNumberType("");

        return employeeView;
    }

    private void checkPageNoAndSize(int pageNo, int pageSize) {
        if (pageNo < MIN_PAGE_NO)
            throw new NoSuchPageException();

        if (pageSize < MIN_PAGE_SIZE)
            throw new IllegalPageSizeException();

    }
}
