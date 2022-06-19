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
@Table(name = "PurchaseOrderDetail", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
        @NamedQuery(name = "PurchaseOrderDetail.selectCount", query = "SELECT COUNT(p) FROM PurchaseOrderDetail p"),
        @NamedQuery(name = "PurchaseOrderDetail.findAll", query = "SELECT p FROM PurchaseOrderDetail p"),
        @NamedQuery(name = "PurchaseOrderDetail.findByPurchaseOrderID", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.purchaseOrderDetailPK.purchaseOrderID = :purchaseOrderID"),
        @NamedQuery(name = "PurchaseOrderDetail.findByPurchaseOrderDetailID", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.purchaseOrderDetailPK.purchaseOrderDetailID = :purchaseOrderDetailID"),
        @NamedQuery(name = "PurchaseOrderDetail.findByDueDate", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.dueDate = :dueDate"),
        @NamedQuery(name = "PurchaseOrderDetail.findByOrderQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.orderQty = :orderQty"),
        @NamedQuery(name = "PurchaseOrderDetail.findByProductID", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.productID = :productID"),
        @NamedQuery(name = "PurchaseOrderDetail.findByUnitPrice", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.unitPrice = :unitPrice"),
        @NamedQuery(name = "PurchaseOrderDetail.findByLineTotal", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.lineTotal = :lineTotal"),
        @NamedQuery(name = "PurchaseOrderDetail.findByReceivedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.receivedQty = :receivedQty"),
        @NamedQuery(name = "PurchaseOrderDetail.findByRejectedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.rejectedQty = :rejectedQty"),
        @NamedQuery(name = "PurchaseOrderDetail.findByStockedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.stockedQty = :stockedQty"),
        @NamedQuery(name = "PurchaseOrderDetail.findByModifiedDate", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.modifiedDate = :modifiedDate")})
public class PurchaseOrderDetail implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseOrderDetailPK purchaseOrderDetailPK;
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "OrderQty")
    private short orderQty;
    @Column(name = "ProductID")
    private int productID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Column(name = "LineTotal")
    private BigDecimal lineTotal;
    @Column(name = "ReceivedQty")
    private BigDecimal receivedQty;
    @Column(name = "RejectedQty")
    private BigDecimal rejectedQty;
    @Column(name = "StockedQty")
    private BigDecimal stockedQty;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "PurchaseOrderID", referencedColumnName = "PurchaseOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrderHeader purchaseOrderHeader;
}
