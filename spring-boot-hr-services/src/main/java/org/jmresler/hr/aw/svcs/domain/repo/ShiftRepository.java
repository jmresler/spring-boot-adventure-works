package org.jmresler.hr.aw.svcs.domain.repo;

import org.jmresler.hr.aw.svcs.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Short> {
}
