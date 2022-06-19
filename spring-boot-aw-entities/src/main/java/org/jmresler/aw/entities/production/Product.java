/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

import lombok.*;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "Product", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ProductNumber"}),
        @UniqueConstraint(columnNames = {"Name"}),
        @UniqueConstraint(columnNames = {"rowguid"})})
@NamedQueries({
        @NamedQuery(name = "Product.selectCount", query = "SELECT COUNT(p) FROM Product p"),
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
        @NamedQuery(name = "Product.findByProductNumber", query = "SELECT p FROM Product p WHERE p.productNumber = :productNumber"),
        @NamedQuery(name = "Product.findByMakeFlag", query = "SELECT p FROM Product p WHERE p.makeFlag = :makeFlag"),
        @NamedQuery(name = "Product.findByFinishedGoodsFlag", query = "SELECT p FROM Product p WHERE p.finishedGoodsFlag = :finishedGoodsFlag"),
        @NamedQuery(name = "Product.findByColor", query = "SELECT p FROM Product p WHERE p.color = :color"),
        @NamedQuery(name = "Product.findBySafetyStockLevel", query = "SELECT p FROM Product p WHERE p.safetyStockLevel = :safetyStockLevel"),
        @NamedQuery(name = "Product.findByReorderPoint", query = "SELECT p FROM Product p WHERE p.reorderPoint = :reorderPoint"),
        @NamedQuery(name = "Product.findByStandardCost", query = "SELECT p FROM Product p WHERE p.standardCost = :standardCost"),
        @NamedQuery(name = "Product.findByListPrice", query = "SELECT p FROM Product p WHERE p.listPrice = :listPrice"),
        @NamedQuery(name = "Product.findBySize", query = "SELECT p FROM Product p WHERE p.size = :size"),
        @NamedQuery(name = "Product.findByWeight", query = "SELECT p FROM Product p WHERE p.weight = :weight"),
        @NamedQuery(name = "Product.findByDaysToManufacture", query = "SELECT p FROM Product p WHERE p.daysToManufacture = :daysToManufacture"),
        @NamedQuery(name = "Product.findByProductLine", query = "SELECT p FROM Product p WHERE p.productLine = :productLine"),
        @NamedQuery(name = "Product.findByClass1", query = "SELECT p FROM Product p WHERE p.class1 = :class1"),
        @NamedQuery(name = "Product.findByStyle", query = "SELECT p FROM Product p WHERE p.style = :style"),
        @NamedQuery(name = "Product.findBySellStartDate", query = "SELECT p FROM Product p WHERE p.sellStartDate = :sellStartDate"),
        @NamedQuery(name = "Product.findBySellEndDate", query = "SELECT p FROM Product p WHERE p.sellEndDate = :sellEndDate"),
        @NamedQuery(name = "Product.findByDiscontinuedDate", query = "SELECT p FROM Product p WHERE p.discontinuedDate = :discontinuedDate"),
        @NamedQuery(name = "Product.findByRowguid", query = "SELECT p FROM Product p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "Product.findByModifiedDate", query = "SELECT p FROM Product p WHERE p.modifiedDate = :modifiedDate")})
public class Product implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private Integer productID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "ProductNumber", nullable = false, length = 25)
    private String productNumber;
    @Column(name = "MakeFlag", nullable = false)
    private boolean makeFlag;
    @Column(name = "FinishedGoodsFlag", nullable = false)
    private boolean finishedGoodsFlag;
    @Column(name = "Color", length = 15)
    private String color;
    @Column(name = "SafetyStockLevel", nullable = false)
    private short safetyStockLevel;
    @Column(name = "ReorderPoint", nullable = false)
    private short reorderPoint;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "StandardCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal standardCost;
    @Column(name = "ListPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal listPrice;
    @Column(name = "Size", length = 5)
    private String size;
    @Column(name = "Weight", precision = 8, scale = 2)
    private BigDecimal weight;
    @Column(name = "DaysToManufacture", nullable = false)
    private int daysToManufacture;
    @Column(name = "ProductLine", length = 2)
    private String productLine;
    @Column(name = "Class", length = 2)
    private String class1;
    @Column(name = "Style", length = 2)
    private String style;
    @Column(name = "SellStartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellStartDate;
    @Column(name = "SellEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellEndDate;
    @Column(name = "DiscontinuedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discontinuedDate;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductInventory> productInventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<TransactionHistory> transactionHistoryCollection;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID")
    @ManyToOne
    private ProductModel productModelID;
    @JoinColumn(name = "ProductSubcategoryID", referencedColumnName = "ProductSubcategoryID")
    @ManyToOne
    private ProductSubcategory productSubcategoryID;
    @JoinColumn(name = "SizeUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    @ManyToOne
    private UnitMeasure sizeUnitMeasureCode;
    @JoinColumn(name = "WeightUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    @ManyToOne
    private UnitMeasure weightUnitMeasureCode;
    @OneToMany(mappedBy = "productAssemblyID")
    private Collection<BillOfMaterials> billOfMaterialsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentID")
    private Collection<BillOfMaterials> billOfMaterialsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<ProductReview> productReviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductCostHistory> productCostHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<WorkOrder> workOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductProductPhoto> productProductPhotoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductListPriceHistory> productListPriceHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductDocument> productDocumentCollection;


}
