/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

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
@Table(name = "SalesOrderDetail", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesOrderDetail.selectCount", query = "SELECT COUNT(s) FROM SalesOrderDetail s"),
        @NamedQuery(name = "SalesOrderDetail.findAll", query = "SELECT s FROM SalesOrderDetail s"),
        @NamedQuery(name = "SalesOrderDetail.findBySalesOrderID", query = "SELECT s FROM SalesOrderDetail s WHERE s.salesOrderDetailPK.salesOrderID = :salesOrderID"),
        @NamedQuery(name = "SalesOrderDetail.findBySalesOrderDetailID", query = "SELECT s FROM SalesOrderDetail s WHERE s.salesOrderDetailPK.salesOrderDetailID = :salesOrderDetailID"),
        @NamedQuery(name = "SalesOrderDetail.findByCarrierTrackingNumber", query = "SELECT s FROM SalesOrderDetail s WHERE s.carrierTrackingNumber = :carrierTrackingNumber"),
        @NamedQuery(name = "SalesOrderDetail.findByOrderQty", query = "SELECT s FROM SalesOrderDetail s WHERE s.orderQty = :orderQty"),
        @NamedQuery(name = "SalesOrderDetail.findByUnitPrice", query = "SELECT s FROM SalesOrderDetail s WHERE s.unitPrice = :unitPrice"),
        @NamedQuery(name = "SalesOrderDetail.findByUnitPriceDiscount", query = "SELECT s FROM SalesOrderDetail s WHERE s.unitPriceDiscount = :unitPriceDiscount"),
        @NamedQuery(name = "SalesOrderDetail.findByLineTotal", query = "SELECT s FROM SalesOrderDetail s WHERE s.lineTotal = :lineTotal"),
        @NamedQuery(name = "SalesOrderDetail.findByRowguid", query = "SELECT s FROM SalesOrderDetail s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesOrderDetail.findByModifiedDate", query = "SELECT s FROM SalesOrderDetail s WHERE s.modifiedDate = :modifiedDate")})
public class SalesOrderDetail implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesOrderDetailPK salesOrderDetailPK;
    @Column(name = "CarrierTrackingNumber")
    private String carrierTrackingNumber;
    @Column(name = "OrderQty")
    private short orderQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Column(name = "UnitPriceDiscount")
    private BigDecimal unitPriceDiscount;
    @Column(name = "LineTotal")
    private BigDecimal lineTotal;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    @JoinColumns({
            @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID"),
            @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")})
    @ManyToOne(optional = false)
    private SpecialOfferProduct specialOfferProduct;
}
