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
