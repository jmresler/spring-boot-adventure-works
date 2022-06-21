package org.jmresler.hr.aw.svcs.domain.repo;

import org.jmresler.hr.aw.svcs.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
