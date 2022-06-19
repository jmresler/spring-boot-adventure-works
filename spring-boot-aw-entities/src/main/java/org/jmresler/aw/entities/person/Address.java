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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "Address", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "Address.selectCount", query = "SELECT COUNT(a) FROM Address a"),
        @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
        @NamedQuery(name = "Address.findByAddressID", query = "SELECT a FROM Address a WHERE a.addressID = :addressID"),
        @NamedQuery(name = "Address.findByAddressLine1", query = "SELECT a FROM Address a WHERE a.addressLine1 = :addressLine1"),
        @NamedQuery(name = "Address.findByAddressLine2", query = "SELECT a FROM Address a WHERE a.addressLine2 = :addressLine2"),
        @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
        @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode"),
        @NamedQuery(name = "Address.findByRowguid", query = "SELECT a FROM Address a WHERE a.rowguid = :rowguid"),
        @NamedQuery(name = "Address.findByModifiedDate", query = "SELECT a FROM Address a WHERE a.modifiedDate = :modifiedDate")})
public class Address implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private Integer addressID;
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Column(name = "City")
    private String city;
    @Column(name = "PostalCode")
    private String postalCode;
    @Lob
    @Column(name = "SpatialLocation")
    private byte[] spatialLocation;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "StateProvinceID", referencedColumnName = "StateProvinceID")
    @ManyToOne(optional = false)
    private StateProvince stateProvinceID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;

}
