package org.jmresler.hr.aw.svcs;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.svcs.domain.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ApplicationTest {

    @Autowired
    protected EmployeeRepository repository;

    @Test
    public void loadContext() {
      repository.findAll().forEach(e -> log.info("{}", e));
    }
}
