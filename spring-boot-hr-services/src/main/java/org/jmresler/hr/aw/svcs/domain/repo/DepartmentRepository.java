package org.jmresler.hr.aw.svcs.domain.repo;

import org.jmresler.hr.aw.svcs.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Short> {
}
