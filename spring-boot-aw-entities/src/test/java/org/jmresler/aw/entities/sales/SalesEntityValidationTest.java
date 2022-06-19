package org.jmresler.aw.entities.sales;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.logging.Logger;

public class SalesEntityValidationTest {

    private static final Logger logger = Logger.getLogger(SalesEntityValidationTest.class.getName());
    private static final EntityManager em = Persistence.createEntityManagerFactory("adventureworks-2017-entities").createEntityManager();

    @Test
    public void testCountryRegionCurrencyCount() {
        Query query = em.createNamedQuery("CountryRegionCurrency.selectCount", CountryRegionCurrency.class);
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 109);
    }

    @Test
    public void testCreditCardCount() {
        Query query = em.createNamedQuery("CreditCard.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19118);
    }

    @Test
    public void testCurrencyCount() {
        Query query = em.createNamedQuery("Currency.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 105);
    }

    @Test
    public void testCurrencyRateCount() {
        Query query = em.createNamedQuery("CurrencyRate.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 13532);
    }

    @Test
    public void testCustomerCount() {
        Query query = em.createNamedQuery("Customer.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19820);
    }

    @Test
    public void testPersonCreditCardCount() {
        Query query = em.createNamedQuery("PersonCreditCard.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19118);
    }

    @Test
    public void testSalesOrderDetailCount() {
        Query query = em.createNamedQuery("SalesOrderDetail.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 121317);
    }

    @Test
    public void testSalesOrderHeaderCount() {
        Query query = em.createNamedQuery("SalesOrderHeader.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 31465);
    }

    @Test
    public void testSalesOrderHeaderSalesReasonCount() {
        Query query = em.createNamedQuery("SalesOrderHeaderSalesReason.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 27647);
    }

    @Test
    public void testSalesPersonCount() {
        TypedQuery<SalesPerson> query = em.createNamedQuery("SalesPerson.findAll", SalesPerson.class);
        Assertions.assertTrue(query.getResultList().size() == 17);
    }

    @Test
    public void testSalesPersonQuotaHistoryCount() {
        Query query = em.createNamedQuery("SalesPersonQuotaHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 163);
    }

    @Test
    public void testSalesReasonCount() {
        Query query = em.createNamedQuery("SalesReason.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 10);
    }

    @Test
    public void testSalesTaxRateCount() {
        Query query = em.createNamedQuery("SalesTaxRate.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 29);
    }

    @Test
    public void testSalesTerritoryCount() {
        Query query = em.createNamedQuery("SalesTerritory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 10);
    }

    @Test
    public void testSalesTerritoryHistoryCount() {
        Query query = em.createNamedQuery("SalesTerritoryHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 17);
    }

    @Test
    public void testShoppingCartItemCount() {
        Query query = em.createNamedQuery("ShoppingCartItem.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 3);
    }

    @Test
    public void testSpecialOfferCount() {
        Query query = em.createNamedQuery("SpecialOffer.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 16);
    }

    @Test
    public void testSpecialOfferProductCount() {
        Query query = em.createNamedQuery("SpecialOfferProduct.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 538);
    }

    @Test
    public void testStoreCount() {
        Query query = em.createNamedQuery("Store.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 701);
    }

    @Test
    public void testVIndividualCustomerCount() {
        Query query = em.createNamedQuery("VIndividualCustomer.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 18508);
    }

    @Test
    public void testVPersonDemographicsCount() {
        Query query = em.createNamedQuery("VPersonDemographics.selectCount", VPersonDemographics.class);
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 19972);
    }

    @Test
    public void testVSalesPersonCount() {
        Query query = em.createNamedQuery("VSalesPerson.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 17);
    }

    @Test
    public void testVSalesPersonSalesByFiscalYearsCount() {
        Query query = em.createNamedQuery("VSalesPersonSalesByFiscalYears.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 14);
    }

    @Test
    public void testVStoreWithAddressesCount() {
        Query query = em.createNamedQuery("VStoreWithAddresses.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 712);
    }

    @Test
    public void testVStoreWithContactsCount() {
        Query query = em.createNamedQuery("VStoreWithContacts.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 753);
    }

    @Test
    public void testVStoreWithDemographicsCount() {
        Query query = em.createNamedQuery("VStoreWithDemographics.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 701);
    }

    @AfterAll
    public static void disconnectEntityManager() {
        try {
            em.close();
        } catch (Exception ignore) {
        }
    }
}
