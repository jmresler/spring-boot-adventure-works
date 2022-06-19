/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.person;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "BusinessEntityAddress", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "BusinessEntityAddress.selectCount", query = "SELECT COUNT(b) FROM BusinessEntityAddress b"),
        @NamedQuery(name = "BusinessEntityAddress.findAll", query = "SELECT b FROM BusinessEntityAddress b"),
        @NamedQuery(name = "BusinessEntityAddress.findByBusinessEntityID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "BusinessEntityAddress.findByAddressID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.addressID = :addressID"),
        @NamedQuery(name = "BusinessEntityAddress.findByAddressTypeID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.addressTypeID = :addressTypeID"),
        @NamedQuery(name = "BusinessEntityAddress.findByRowguid", query = "SELECT b FROM BusinessEntityAddress b WHERE b.rowguid = :rowguid"),
        @NamedQuery(name = "BusinessEntityAddress.findByModifiedDate", query = "SELECT b FROM BusinessEntityAddress b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntityAddress implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusinessEntityAddressPK businessEntityAddressPK;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Address address;
    @JoinColumn(name = "AddressTypeID", referencedColumnName = "AddressTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AddressType addressType;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BusinessEntity businessEntity;

}
