package org.jmresler.aw.entities.purchasing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.logging.Logger;

public class PurchasingEntityValidationTest {

    private static final Logger logger = Logger.getLogger(PurchasingEntityValidationTest.class.getName());
    private static EntityManager em;

    @BeforeAll
    public static void connectEntityManager() {
        em = Persistence.createEntityManagerFactory("adventureworks-2017-entities").createEntityManager();
    }

    @Test
    public void testProductVendorCount() {
        Query query = em.createNamedQuery("ProductVendor.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 460);
    }

    @Test
    public void testPurchaseOrderDetailCount() {
        Query query = em.createNamedQuery("PurchaseOrderDetail.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 8845);
    }

    @Test
    public void testPurchaseOrderHeaderCount() {
        Query query = em.createNamedQuery("PurchaseOrderHeader.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 4012);
    }

    @Test
    public void testShipMethodCount() {
        Query query = em.createNamedQuery("ShipMethod.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 5);
    }

    @Test
    public void testVendorCount() {
        Query query = em.createNamedQuery("Vendor.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 104);
    }

    @Test
    public void testVVendorWithAddressesCount() {
        Query query = em.createNamedQuery("VVendorWithAddresses.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 104);
    }

    @Test
    public void testVVendorWithContactsCount() {
        Query query = em.createNamedQuery("VVendorWithContacts.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 156);
    }

    @AfterAll
    public static void disconnectEntityManager() {
        try {
            em.close();
        } catch (Exception ignore) {
        }
    }

}
