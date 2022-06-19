/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

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
@Table(name = "TransactionHistory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "TransactionHistory.selectCount", query = "SELECT COUNT(t) FROM TransactionHistory t"),
        @NamedQuery(name = "TransactionHistory.findAll", query = "SELECT t FROM TransactionHistory t"),
        @NamedQuery(name = "TransactionHistory.findByTransactionID", query = "SELECT t FROM TransactionHistory t WHERE t.transactionID = :transactionID"),
        @NamedQuery(name = "TransactionHistory.findByReferenceOrderID", query = "SELECT t FROM TransactionHistory t WHERE t.referenceOrderID = :referenceOrderID"),
        @NamedQuery(name = "TransactionHistory.findByReferenceOrderLineID", query = "SELECT t FROM TransactionHistory t WHERE t.referenceOrderLineID = :referenceOrderLineID"),
        @NamedQuery(name = "TransactionHistory.findByTransactionDate", query = "SELECT t FROM TransactionHistory t WHERE t.transactionDate = :transactionDate"),
        @NamedQuery(name = "TransactionHistory.findByTransactionType", query = "SELECT t FROM TransactionHistory t WHERE t.transactionType = :transactionType"),
        @NamedQuery(name = "TransactionHistory.findByQuantity", query = "SELECT t FROM TransactionHistory t WHERE t.quantity = :quantity"),
        @NamedQuery(name = "TransactionHistory.findByActualCost", query = "SELECT t FROM TransactionHistory t WHERE t.actualCost = :actualCost"),
        @NamedQuery(name = "TransactionHistory.findByModifiedDate", query = "SELECT t FROM TransactionHistory t WHERE t.modifiedDate = :modifiedDate")})
public class TransactionHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID", nullable = false)
    private Integer transactionID;
    @Column(name = "ReferenceOrderID", nullable = false)
    private int referenceOrderID;
    @Column(name = "ReferenceOrderLineID", nullable = false)
    private int referenceOrderLineID;
    @Column(name = "TransactionDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Column(name = "TransactionType", nullable = false, length = 1)
    private String transactionType;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ActualCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal actualCost;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product productID;

}
