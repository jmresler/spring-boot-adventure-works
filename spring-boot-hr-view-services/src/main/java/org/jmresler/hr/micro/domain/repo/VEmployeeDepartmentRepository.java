package org.jmresler.hr.micro.domain.repo;

import org.jmresler.hr.micro.domain.VEmployeeDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VEmployeeDepartmentRepository extends JpaRepository<VEmployeeDepartment, Integer> {

    Page<VEmployeeDepartment> findAll(final Pageable pageable);
    Page<VEmployeeDepartment> findByFirstNameAndLastName(final String firstName, final String lastName, final Pageable pageable);
    Page<VEmployeeDepartment> findByDepartment(final String department, final Pageable pageable);
}
