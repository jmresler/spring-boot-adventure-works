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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "Vendor", catalog = "AdventureWorks2017", schema = "Purchasing")
public class Vendor implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "AccountNumber")
    private String accountNumber;
    @Column(name = "Name")
    private String name;
    @Column(name = "CreditRating")
    private short creditRating;
    @Column(name = "PreferredVendorStatus")
    private boolean preferredVendorStatus;
    @Column(name = "ActiveFlag")
    private boolean activeFlag;
    @Column(name = "PurchasingWebServiceURL")
    private String purchasingWebServiceURL;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Collection<ProductVendor> productVendorCollection;

}
