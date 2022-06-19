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

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vVendorWithAddresses", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
        @NamedQuery(name = "VVendorWithAddresses.selectCount", query = "SELECT COUNT(v) FROM VVendorWithAddresses v"),
        @NamedQuery(name = "VVendorWithAddresses.findAll", query = "SELECT v FROM VVendorWithAddresses v"),
        @NamedQuery(name = "VVendorWithAddresses.findByBusinessEntityID", query = "SELECT v FROM VVendorWithAddresses v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VVendorWithAddresses.findByName", query = "SELECT v FROM VVendorWithAddresses v WHERE v.name = :name"),
        @NamedQuery(name = "VVendorWithAddresses.findByAddressType", query = "SELECT v FROM VVendorWithAddresses v WHERE v.addressType = :addressType"),
        @NamedQuery(name = "VVendorWithAddresses.findByAddressLine1", query = "SELECT v FROM VVendorWithAddresses v WHERE v.addressLine1 = :addressLine1"),
        @NamedQuery(name = "VVendorWithAddresses.findByAddressLine2", query = "SELECT v FROM VVendorWithAddresses v WHERE v.addressLine2 = :addressLine2"),
        @NamedQuery(name = "VVendorWithAddresses.findByCity", query = "SELECT v FROM VVendorWithAddresses v WHERE v.city = :city"),
        @NamedQuery(name = "VVendorWithAddresses.findByStateProvinceName", query = "SELECT v FROM VVendorWithAddresses v WHERE v.stateProvinceName = :stateProvinceName"),
        @NamedQuery(name = "VVendorWithAddresses.findByPostalCode", query = "SELECT v FROM VVendorWithAddresses v WHERE v.postalCode = :postalCode"),
        @NamedQuery(name = "VVendorWithAddresses.findByCountryRegionName", query = "SELECT v FROM VVendorWithAddresses v WHERE v.countryRegionName = :countryRegionName")})
public class VVendorWithAddresses implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Name")
    private String name;
    @Column(name = "AddressType")
    private String addressType;
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Column(name = "City")
    private String city;
    @Column(name = "StateProvinceName")
    private String stateProvinceName;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "CountryRegionName")
    private String countryRegionName;

}
