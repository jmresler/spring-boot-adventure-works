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
@Table(name = "TransactionHistoryArchive", catalog = "AdventureWorks2017", schema = "Production")
public class TransactionHistoryArchive implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "TransactionID", nullable = false)
    private Integer transactionID;
    @Column(name = "ProductID", nullable = false)
    private int productID;
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

}
