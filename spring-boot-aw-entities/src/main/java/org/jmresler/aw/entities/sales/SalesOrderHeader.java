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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "SalesOrderHeader", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesOrderHeader.selectCount", query = "SELECT COUNT(s) FROM SalesOrderHeader s"),
        @NamedQuery(name = "SalesOrderHeader.findAll", query = "SELECT s FROM SalesOrderHeader s"),
        @NamedQuery(name = "SalesOrderHeader.findBySalesOrderID", query = "SELECT s FROM SalesOrderHeader s WHERE s.salesOrderID = :salesOrderID"),
        @NamedQuery(name = "SalesOrderHeader.findByRevisionNumber", query = "SELECT s FROM SalesOrderHeader s WHERE s.revisionNumber = :revisionNumber"),
        @NamedQuery(name = "SalesOrderHeader.findByOrderDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.orderDate = :orderDate"),
        @NamedQuery(name = "SalesOrderHeader.findByDueDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.dueDate = :dueDate"),
        @NamedQuery(name = "SalesOrderHeader.findByShipDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.shipDate = :shipDate"),
        @NamedQuery(name = "SalesOrderHeader.findByStatus", query = "SELECT s FROM SalesOrderHeader s WHERE s.status = :status"),
        @NamedQuery(name = "SalesOrderHeader.findByOnlineOrderFlag", query = "SELECT s FROM SalesOrderHeader s WHERE s.onlineOrderFlag = :onlineOrderFlag"),
        @NamedQuery(name = "SalesOrderHeader.findBySalesOrderNumber", query = "SELECT s FROM SalesOrderHeader s WHERE s.salesOrderNumber = :salesOrderNumber"),
        @NamedQuery(name = "SalesOrderHeader.findByPurchaseOrderNumber", query = "SELECT s FROM SalesOrderHeader s WHERE s.purchaseOrderNumber = :purchaseOrderNumber"),
        @NamedQuery(name = "SalesOrderHeader.findByAccountNumber", query = "SELECT s FROM SalesOrderHeader s WHERE s.accountNumber = :accountNumber"),
        @NamedQuery(name = "SalesOrderHeader.findByBillToAddressID", query = "SELECT s FROM SalesOrderHeader s WHERE s.billToAddressID = :billToAddressID"),
        @NamedQuery(name = "SalesOrderHeader.findByShipToAddressID", query = "SELECT s FROM SalesOrderHeader s WHERE s.shipToAddressID = :shipToAddressID"),
        @NamedQuery(name = "SalesOrderHeader.findByShipMethodID", query = "SELECT s FROM SalesOrderHeader s WHERE s.shipMethodID = :shipMethodID"),
        @NamedQuery(name = "SalesOrderHeader.findByCreditCardApprovalCode", query = "SELECT s FROM SalesOrderHeader s WHERE s.creditCardApprovalCode = :creditCardApprovalCode"),
        @NamedQuery(name = "SalesOrderHeader.findBySubTotal", query = "SELECT s FROM SalesOrderHeader s WHERE s.subTotal = :subTotal"),
        @NamedQuery(name = "SalesOrderHeader.findByTaxAmt", query = "SELECT s FROM SalesOrderHeader s WHERE s.taxAmt = :taxAmt"),
        @NamedQuery(name = "SalesOrderHeader.findByFreight", query = "SELECT s FROM SalesOrderHeader s WHERE s.freight = :freight"),
        @NamedQuery(name = "SalesOrderHeader.findByTotalDue", query = "SELECT s FROM SalesOrderHeader s WHERE s.totalDue = :totalDue"),
        @NamedQuery(name = "SalesOrderHeader.findByComment", query = "SELECT s FROM SalesOrderHeader s WHERE s.comment = :comment"),
        @NamedQuery(name = "SalesOrderHeader.findByRowguid", query = "SELECT s FROM SalesOrderHeader s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesOrderHeader.findByModifiedDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.modifiedDate = :modifiedDate")})
public class SalesOrderHeader implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesOrderID")
    private Integer salesOrderID;
    @Column(name = "RevisionNumber")
    private short revisionNumber;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Column(name = "Status")
    private short status;
    @Column(name = "OnlineOrderFlag")
    private boolean onlineOrderFlag;
    @Column(name = "SalesOrderNumber")
    private String salesOrderNumber;
    @Column(name = "PurchaseOrderNumber")
    private String purchaseOrderNumber;
    @Column(name = "AccountNumber")
    private String accountNumber;
    @Column(name = "BillToAddressID")
    private int billToAddressID;
    @Column(name = "ShipToAddressID")
    private int shipToAddressID;
    @Column(name = "ShipMethodID")
    private int shipMethodID;
    @Column(name = "CreditCardApprovalCode")
    private String creditCardApprovalCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SubTotal")
    private BigDecimal subTotal;
    @Column(name = "TaxAmt")
    private BigDecimal taxAmt;
    @Column(name = "Freight")
    private BigDecimal freight;
    @Column(name = "TotalDue")
    private BigDecimal totalDue;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID")
    @ManyToOne
    private CreditCard creditCardID;
    @JoinColumn(name = "CurrencyRateID", referencedColumnName = "CurrencyRateID")
    @ManyToOne
    private CurrencyRate currencyRateID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customer customerID;
    @JoinColumn(name = "SalesPersonID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private SalesPerson salesPersonID;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;
}
