/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.purchasing;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "ProductVendor", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
        @NamedQuery(name = "ProductVendor.selectCount", query = "SELECT COUNT(p) FROM ProductVendor p"),
        @NamedQuery(name = "ProductVendor.findAll", query = "SELECT p FROM ProductVendor p"),
        @NamedQuery(name = "ProductVendor.findByProductID", query = "SELECT p FROM ProductVendor p WHERE p.productVendorPK.productID = :productID"),
        @NamedQuery(name = "ProductVendor.findByBusinessEntityID", query = "SELECT p FROM ProductVendor p WHERE p.productVendorPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "ProductVendor.findByAverageLeadTime", query = "SELECT p FROM ProductVendor p WHERE p.averageLeadTime = :averageLeadTime"),
        @NamedQuery(name = "ProductVendor.findByStandardPrice", query = "SELECT p FROM ProductVendor p WHERE p.standardPrice = :standardPrice"),
        @NamedQuery(name = "ProductVendor.findByLastReceiptCost", query = "SELECT p FROM ProductVendor p WHERE p.lastReceiptCost = :lastReceiptCost"),
        @NamedQuery(name = "ProductVendor.findByLastReceiptDate", query = "SELECT p FROM ProductVendor p WHERE p.lastReceiptDate = :lastReceiptDate"),
        @NamedQuery(name = "ProductVendor.findByMinOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.minOrderQty = :minOrderQty"),
        @NamedQuery(name = "ProductVendor.findByMaxOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.maxOrderQty = :maxOrderQty"),
        @NamedQuery(name = "ProductVendor.findByOnOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.onOrderQty = :onOrderQty"),
        @NamedQuery(name = "ProductVendor.findByUnitMeasureCode", query = "SELECT p FROM ProductVendor p WHERE p.unitMeasureCode = :unitMeasureCode"),
        @NamedQuery(name = "ProductVendor.findByModifiedDate", query = "SELECT p FROM ProductVendor p WHERE p.modifiedDate = :modifiedDate")})
public class ProductVendor implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductVendorPK productVendorPK;
    @Column(name = "AverageLeadTime")
    private int averageLeadTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "StandardPrice")
    private BigDecimal standardPrice;
    @Column(name = "LastReceiptCost")
    private BigDecimal lastReceiptCost;
    @Column(name = "LastReceiptDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReceiptDate;
    @Column(name = "MinOrderQty")
    private int minOrderQty;
    @Column(name = "MaxOrderQty")
    private int maxOrderQty;
    @Column(name = "OnOrderQty")
    private Integer onOrderQty;
    @Column(name = "UnitMeasureCode")
    private String unitMeasureCode;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendor vendor;
}
