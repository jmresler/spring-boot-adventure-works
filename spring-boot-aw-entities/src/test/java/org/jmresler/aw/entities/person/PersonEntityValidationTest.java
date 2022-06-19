package org.jmresler.aw.entities.person;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.logging.Logger;

public class PersonEntityValidationTest {

    private static final Logger logger = Logger.getLogger(PersonEntityValidationTest.class.getName());
    private static EntityManager em;

    @BeforeAll
    public static void connectEntityManager() {
        em = Persistence.createEntityManagerFactory("adventureworks-2017-entities").createEntityManager();
    }

    @Test
    public void testVStateProvinceCountryRegionCount() {
        Query query = em.createNamedQuery("VStateProvinceCountryRegion.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 181);
    }

    @Test
    public void testVadditionalContactInfoCount() {
        Query query = em.createNamedQuery("VAdditionalContactInfo.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 10);
    }

    @Test
    public void validateStateProvinceCount() {
        Query query = em.createNamedQuery("StateProvince.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 181);

    }

    @Test
    public void validatePhoneNumberTypeCount() {
        Query query = em.createNamedQuery("PhoneNumberType.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 3);
    }

    @Test
    public void validatePersonPhoneCount() {
        Query query = em.createNamedQuery("PersonPhone.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19972);
    }

    @Test
    public void validatePersonCount() {
        Query query = em.createNamedQuery("Person.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19972);
    }

    @Test
    public void validatePasswordCount() {
        Query query = em.createNamedQuery("Password.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19972);
    }

    @Test
    public void validateEmailAddressCount() {
        Query query = em.createNamedQuery("EmailAddress.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19972);
    }

    @Test
    public void validateCountryRegionCount() {
        Query query = em.createNamedQuery("CountryRegion.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 238);
    }

    @Test
    public void validateContactTypeCount() {
        Query query = em.createNamedQuery("ContactType.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 20);
    }

    @Test
    public void validateBusinessEntityContactCount() {
        Query query = em.createNamedQuery("BusinessEntityContact.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 909);
    }

    @Test
    public void validateBusinessEntityCount() {
        Query query = em.createNamedQuery("BusinessEntity.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 20777);
    }

    @Test
    public void validateAddressTypeCount() {
        Query query = em.createNamedQuery("AddressType.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 6);
    }

    @Test
    public void validateAddressCount() {
        Query query = em.createNamedQuery("Address.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19614);

    }

    @AfterAll
    public static void disconnectEntityManager() {
        try {
            em.close();
        } catch (Exception ignore) {
        }
    }
}
