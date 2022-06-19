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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "Customer", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "Customer.selectCount", query = "SELECT COUNT(c) FROM Customer c"),
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
        @NamedQuery(name = "Customer.findByCustomerID", query = "SELECT c FROM Customer c WHERE c.customerID = :customerID"),
        @NamedQuery(name = "Customer.findByPersonID", query = "SELECT c FROM Customer c WHERE c.personID = :personID"),
        @NamedQuery(name = "Customer.findByAccountNumber", query = "SELECT c FROM Customer c WHERE c.accountNumber = :accountNumber"),
        @NamedQuery(name = "Customer.findByRowguid", query = "SELECT c FROM Customer c WHERE c.rowguid = :rowguid"),
        @NamedQuery(name = "Customer.findByModifiedDate", query = "SELECT c FROM Customer c WHERE c.modifiedDate = :modifiedDate")})
public class Customer implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerID;
    @Column(name = "PersonID")
    private Integer personID;
    @Column(name = "AccountNumber")
    private String accountNumber;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @JoinColumn(name = "StoreID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private Store storeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;
}
