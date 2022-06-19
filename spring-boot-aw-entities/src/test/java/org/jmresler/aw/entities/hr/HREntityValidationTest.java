package org.jmresler.aw.entities.hr;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.logging.Logger;

public class HREntityValidationTest {

    private static final Logger logger = Logger.getLogger(HREntityValidationTest.class.getName());
    private static EntityManager em;

    @BeforeAll
    public static void connectEntityManager() {
        em = Persistence.createEntityManagerFactory("adventureworks-2017-entities").createEntityManager();
    }

    @Test
    public void validateEmployeeCount() {
        Query query = em.createNamedQuery("Employee.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 290);
    }


    @Test
    public void validateDepartmentCount() {
        Query query = em.createNamedQuery("Department.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 16);
    }


    @Test
    public void validateEmployeeDepartmentHistoryCount() {
        Query query = em.createNamedQuery("EmployeeDepartmentHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 296);
    }

    @Test
    public void validateEmployeePayHistoryCount() {
        Query query = em.createNamedQuery("EmployeePayHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 316);

    }

    @Test
    public void validateJobCandidateCount() {
        Query query = em.createNamedQuery("JobCandidate.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 13);
    }

    @Test
    public void validateShiftCount() {
        Query query = em.createNamedQuery("Shift.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 3);
    }

    @Test
    public void validateVEmployeeCount() {
        Query query = em.createNamedQuery("VEmployee.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 290);

    }

    @Test
    public void validateVEmployeeDepartmentCount() {
        Query query = em.createNamedQuery("VEmployeeDepartment.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 290);
    }

    @Test
    public void validateVEmployeeDepartmentHistoryCount() {
        Query query = em.createNamedQuery("VEmployeeDepartmentHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 296);
    }

    @Test
    public void validateVJobCandidateCount() {
        Query query = em.createNamedQuery("VJobCandidate.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 13);
    }

    @Test
    public void validateVJobCandidateEducationCount() {
        Query query = em.createNamedQuery("VJobCandidateEducation.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 16);
    }

    @Test
    public void validateVJobCandidateEmploymentCount() {
        Query query = em.createNamedQuery("VJobCandidateEmployment.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 30);
    }


    @AfterAll
    public static void disconnectEntityManager() {
        try {
            em.close();
        } catch (Exception ignore) {
        }
    }
}
