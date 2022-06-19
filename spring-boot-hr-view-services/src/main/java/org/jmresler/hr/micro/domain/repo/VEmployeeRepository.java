package org.jmresler.hr.micro.domain.repo;

import org.jmresler.hr.micro.domain.VEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VEmployeeRepository extends JpaRepository<VEmployee, Integer> {

    Page<VEmployee> findAll(final Pageable page);
    Page<VEmployee> findByTitle(final String title, final Pageable page);
    Page<VEmployee> findByFirstNameAndLastName(final String firstName, final String lastName, final Pageable page);
    Optional<VEmployee> findByEmailAddress(final String emailAddress);

}
