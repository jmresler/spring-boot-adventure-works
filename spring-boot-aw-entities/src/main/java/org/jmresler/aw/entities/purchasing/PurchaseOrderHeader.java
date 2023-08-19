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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "PurchaseOrderHeader", catalog = "AdventureWorks2017", schema = "Purchasing")
public class PurchaseOrderHeader implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PurchaseOrderID")
    private Integer purchaseOrderID;
    @Column(name = "RevisionNumber")
    private short revisionNumber;
    @Column(name = "Status")
    private short status;
    @Column(name = "EmployeeID")
    private int employeeID;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SubTotal")
    private BigDecimal subTotal;
    @Column(name = "TaxAmt")
    private BigDecimal taxAmt;
    @Column(name = "Freight")
    private BigDecimal freight;
    @Column(name = "TotalDue")
    private BigDecimal totalDue;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderHeader")
    private Collection<PurchaseOrderDetail> purchaseOrderDetailCollection;
    @JoinColumn(name = "ShipMethodID", referencedColumnName = "ShipMethodID")
    @ManyToOne(optional = false)
    private ShipMethod shipMethodID;
    @JoinColumn(name = "VendorID", referencedColumnName = "BusinessEntityID")
    @ManyToOne(optional = false)
    private Vendor vendorID;
}
