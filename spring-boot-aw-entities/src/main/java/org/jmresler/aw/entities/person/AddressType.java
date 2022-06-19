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
@Table(name = "AddressType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "AddressType.selectCount", query = "SELECT COUNT(a) FROM AddressType a"),
        @NamedQuery(name = "AddressType.findAll", query = "SELECT a FROM AddressType a"),
        @NamedQuery(name = "AddressType.findByAddressTypeID", query = "SELECT a FROM AddressType a WHERE a.addressTypeID = :addressTypeID"),
        @NamedQuery(name = "AddressType.findByName", query = "SELECT a FROM AddressType a WHERE a.name = :name"),
        @NamedQuery(name = "AddressType.findByRowguid", query = "SELECT a FROM AddressType a WHERE a.rowguid = :rowguid"),
        @NamedQuery(name = "AddressType.findByModifiedDate", query = "SELECT a FROM AddressType a WHERE a.modifiedDate = :modifiedDate")})
public class AddressType implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressTypeID")
    private Integer addressTypeID;
    @Column(name = "Name")
    private String name;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressType")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;


}
