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

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vStoreWithAddresses", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VStoreWithAddresses.selectCount", query = "SELECT COUNT(v) FROM VStoreWithAddresses v"),
        @NamedQuery(name = "VStoreWithAddresses.findAll", query = "SELECT v FROM VStoreWithAddresses v"),
        @NamedQuery(name = "VStoreWithAddresses.findByBusinessEntityID", query = "SELECT v FROM VStoreWithAddresses v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VStoreWithAddresses.findByName", query = "SELECT v FROM VStoreWithAddresses v WHERE v.name = :name"),
        @NamedQuery(name = "VStoreWithAddresses.findByAddressType", query = "SELECT v FROM VStoreWithAddresses v WHERE v.addressType = :addressType"),
        @NamedQuery(name = "VStoreWithAddresses.findByAddressLine1", query = "SELECT v FROM VStoreWithAddresses v WHERE v.addressLine1 = :addressLine1"),
        @NamedQuery(name = "VStoreWithAddresses.findByAddressLine2", query = "SELECT v FROM VStoreWithAddresses v WHERE v.addressLine2 = :addressLine2"),
        @NamedQuery(name = "VStoreWithAddresses.findByCity", query = "SELECT v FROM VStoreWithAddresses v WHERE v.city = :city"),
        @NamedQuery(name = "VStoreWithAddresses.findByStateProvinceName", query = "SELECT v FROM VStoreWithAddresses v WHERE v.stateProvinceName = :stateProvinceName"),
        @NamedQuery(name = "VStoreWithAddresses.findByPostalCode", query = "SELECT v FROM VStoreWithAddresses v WHERE v.postalCode = :postalCode"),
        @NamedQuery(name = "VStoreWithAddresses.findByCountryRegionName", query = "SELECT v FROM VStoreWithAddresses v WHERE v.countryRegionName = :countryRegionName")})
public class VStoreWithAddresses implements Serializable, JsonSerializable {

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
