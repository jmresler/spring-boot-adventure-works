package org.jmresler.aw.entities.production;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.logging.Logger;

public class ProductionEntityValidationTest {

    private static final Logger logger = Logger.getLogger(ProductionEntityValidationTest.class.getName());
    private static EntityManager em;

    @BeforeAll
    public static void connectEntityManager() {
        em = Persistence.createEntityManagerFactory("adventureworks-2017-entities").createEntityManager();
    }

    @Test
    public void testWorkOrderRoutingCount() {
        Query query = em.createNamedQuery("WorkOrderRouting.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 67131L);
    }

    @Test
    public void testWorkOrderCount() {
        Query query = em.createNamedQuery("WorkOrder.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 72591L);
    }

    @Test
    public void testVProductModelInstructionsCount() {
        Query query = em.createNamedQuery("VProductModelInstructions.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 131L);
    }

    @Test
    public void testVProductModelCatalogDescriptionCount() {
        Query query = em.createNamedQuery("VProductModelCatalogDescription.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 6);

    }

    @Test
    public void testVProductAndDescriptionCount() {
        Query query = em.createNamedQuery("VProductAndDescription.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 1764);
    }

    @Test
    public void testUnitMeasureCount() {
        Query query = em.createNamedQuery("UnitMeasure.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 38);
    }

    @Test
    public void testTransactionHistoryArchiveCount() {
        Query query = em.createNamedQuery("TransactionHistoryArchive.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 89253);
    }

    @Test
    public void testTransactionHistoryCount() {
        Query query = em.createNamedQuery("TransactionHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 113443);
    }

    @Test
    public void testScrapReasonCount() {
        Query query = em.createNamedQuery("ScrapReason.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 16);
    }

    @Test
    public void testProductSubcategoryCount() {
        Query query = em.createNamedQuery("ProductSubcategory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 37);
    }

    @Test
    public void testProductReviewCount() {
        Query query = em.createNamedQuery("ProductReview.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 4);
    }

    @Test
    public void testProductProductPhotoCount() {
        Query query = em.createNamedQuery("ProductProductPhoto.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 504);
    }

    @Test
    public void testProductPhotoCount() {
        Query query = em.createNamedQuery("ProductPhoto.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 101);
    }

    @Test
    public void testProductModelProductDescriptionCultureCount() {
        Query query = em.createNamedQuery("ProductModelProductDescriptionCulture.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 762);
    }

    @Test
    public void testProductModelIllustrationCount() {
        Query query = em.createNamedQuery("ProductModelIllustration.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 7);
    }

    @Test
    public void testProductModelCount() {
        Query query = em.createNamedQuery("ProductModel.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 128);
    }

    @Test
    public void testProductListPriceHistoryCount() {
        Query query = em.createNamedQuery("ProductListPriceHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 395);
    }

    @Test
    public void testProductInventoryCount() {
        Query query = em.createNamedQuery("ProductInventory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 1069);
    }

    @Test
    public void testProductDocumentCount() {
        Query query = em.createNamedQuery("ProductDocument.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 32);
    }

    @Test
    public void testProductDescriptionCount() {
        Query query = em.createNamedQuery("ProductDescription.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 762);
    }

    @Test
    public void testProductCostHistoryCount() {
        Query query = em.createNamedQuery("ProductCostHistory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 395);
    }

    @Test
    public void testProductCategoryCount() {
        Query query = em.createNamedQuery("ProductCategory.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 4);
    }

    @Test
    public void testProductCount() {
        Query query = em.createNamedQuery("Product.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 504);
    }

    @Test
    public void testLocationCount() {
        Query query = em.createNamedQuery("Location.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 14);
    }

    @Test
    public void testIllustrationCount() {
        Query query = em.createNamedQuery("Illustration.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 5);
    }

    @Test
    public void testDocumentCount() {
        Query query = em.createNamedQuery("Document.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 13);
    }

    @Test
    public void testCultureCount() {
        Query query = em.createNamedQuery("Culture.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 8);
    }

    @Test
    public void testBillOfMaterialsCount() {
        Query query = em.createNamedQuery("BillOfMaterials.selectCount");
        Long count = (Long) query.getSingleResult();
        Assertions.assertTrue(count == 2679);
    }

    @AfterAll
    public static void disconnectEntityManager() {
        try {
            em.close();
        } catch (Exception ignore) {
        }
    }
}
