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

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vSalesPerson", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VSalesPerson.selectCount", query = "SELECT COUNT(v) FROM VSalesPerson v"),
        @NamedQuery(name = "VSalesPerson.findAll", query = "SELECT v FROM VSalesPerson v"),
        @NamedQuery(name = "VSalesPerson.findByBusinessEntityID", query = "SELECT v FROM VSalesPerson v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VSalesPerson.findByTitle", query = "SELECT v FROM VSalesPerson v WHERE v.title = :title"),
        @NamedQuery(name = "VSalesPerson.findByFirstName", query = "SELECT v FROM VSalesPerson v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VSalesPerson.findByMiddleName", query = "SELECT v FROM VSalesPerson v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VSalesPerson.findByLastName", query = "SELECT v FROM VSalesPerson v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VSalesPerson.findBySuffix", query = "SELECT v FROM VSalesPerson v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VSalesPerson.findByJobTitle", query = "SELECT v FROM VSalesPerson v WHERE v.jobTitle = :jobTitle"),
        @NamedQuery(name = "VSalesPerson.findByPhoneNumber", query = "SELECT v FROM VSalesPerson v WHERE v.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "VSalesPerson.findByPhoneNumberType", query = "SELECT v FROM VSalesPerson v WHERE v.phoneNumberType = :phoneNumberType"),
        @NamedQuery(name = "VSalesPerson.findByEmailAddress", query = "SELECT v FROM VSalesPerson v WHERE v.emailAddress = :emailAddress"),
        @NamedQuery(name = "VSalesPerson.findByEmailPromotion", query = "SELECT v FROM VSalesPerson v WHERE v.emailPromotion = :emailPromotion"),
        @NamedQuery(name = "VSalesPerson.findByAddressLine1", query = "SELECT v FROM VSalesPerson v WHERE v.addressLine1 = :addressLine1"),
        @NamedQuery(name = "VSalesPerson.findByAddressLine2", query = "SELECT v FROM VSalesPerson v WHERE v.addressLine2 = :addressLine2"),
        @NamedQuery(name = "VSalesPerson.findByCity", query = "SELECT v FROM VSalesPerson v WHERE v.city = :city"),
        @NamedQuery(name = "VSalesPerson.findByStateProvinceName", query = "SELECT v FROM VSalesPerson v WHERE v.stateProvinceName = :stateProvinceName"),
        @NamedQuery(name = "VSalesPerson.findByPostalCode", query = "SELECT v FROM VSalesPerson v WHERE v.postalCode = :postalCode"),
        @NamedQuery(name = "VSalesPerson.findByCountryRegionName", query = "SELECT v FROM VSalesPerson v WHERE v.countryRegionName = :countryRegionName"),
        @NamedQuery(name = "VSalesPerson.findByTerritoryName", query = "SELECT v FROM VSalesPerson v WHERE v.territoryName = :territoryName"),
        @NamedQuery(name = "VSalesPerson.findByTerritoryGroup", query = "SELECT v FROM VSalesPerson v WHERE v.territoryGroup = :territoryGroup"),
        @NamedQuery(name = "VSalesPerson.findBySalesQuota", query = "SELECT v FROM VSalesPerson v WHERE v.salesQuota = :salesQuota"),
        @NamedQuery(name = "VSalesPerson.findBySalesYTD", query = "SELECT v FROM VSalesPerson v WHERE v.salesYTD = :salesYTD"),
        @NamedQuery(name = "VSalesPerson.findBySalesLastYear", query = "SELECT v FROM VSalesPerson v WHERE v.salesLastYear = :salesLastYear")})
public class VSalesPerson implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Suffix")
    private String suffix;
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "PhoneNumberType")
    private String phoneNumberType;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "EmailPromotion")
    private int emailPromotion;
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
    @Column(name = "TerritoryName")
    private String territoryName;
    @Column(name = "TerritoryGroup")
    private String territoryGroup;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
}
