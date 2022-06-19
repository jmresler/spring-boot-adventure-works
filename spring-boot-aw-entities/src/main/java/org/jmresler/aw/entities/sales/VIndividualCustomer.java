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
@Table(name = "vIndividualCustomer", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VIndividualCustomer.selectCount", query = "SELECT COUNT(v) FROM VIndividualCustomer v"),
        @NamedQuery(name = "VIndividualCustomer.findAll", query = "SELECT v FROM VIndividualCustomer v"),
        @NamedQuery(name = "VIndividualCustomer.findByBusinessEntityID", query = "SELECT v FROM VIndividualCustomer v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VIndividualCustomer.findByTitle", query = "SELECT v FROM VIndividualCustomer v WHERE v.title = :title"),
        @NamedQuery(name = "VIndividualCustomer.findByFirstName", query = "SELECT v FROM VIndividualCustomer v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VIndividualCustomer.findByMiddleName", query = "SELECT v FROM VIndividualCustomer v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VIndividualCustomer.findByLastName", query = "SELECT v FROM VIndividualCustomer v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VIndividualCustomer.findBySuffix", query = "SELECT v FROM VIndividualCustomer v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VIndividualCustomer.findByPhoneNumber", query = "SELECT v FROM VIndividualCustomer v WHERE v.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "VIndividualCustomer.findByPhoneNumberType", query = "SELECT v FROM VIndividualCustomer v WHERE v.phoneNumberType = :phoneNumberType"),
        @NamedQuery(name = "VIndividualCustomer.findByEmailAddress", query = "SELECT v FROM VIndividualCustomer v WHERE v.emailAddress = :emailAddress"),
        @NamedQuery(name = "VIndividualCustomer.findByEmailPromotion", query = "SELECT v FROM VIndividualCustomer v WHERE v.emailPromotion = :emailPromotion"),
        @NamedQuery(name = "VIndividualCustomer.findByAddressType", query = "SELECT v FROM VIndividualCustomer v WHERE v.addressType = :addressType"),
        @NamedQuery(name = "VIndividualCustomer.findByAddressLine1", query = "SELECT v FROM VIndividualCustomer v WHERE v.addressLine1 = :addressLine1"),
        @NamedQuery(name = "VIndividualCustomer.findByAddressLine2", query = "SELECT v FROM VIndividualCustomer v WHERE v.addressLine2 = :addressLine2"),
        @NamedQuery(name = "VIndividualCustomer.findByCity", query = "SELECT v FROM VIndividualCustomer v WHERE v.city = :city"),
        @NamedQuery(name = "VIndividualCustomer.findByStateProvinceName", query = "SELECT v FROM VIndividualCustomer v WHERE v.stateProvinceName = :stateProvinceName"),
        @NamedQuery(name = "VIndividualCustomer.findByPostalCode", query = "SELECT v FROM VIndividualCustomer v WHERE v.postalCode = :postalCode"),
        @NamedQuery(name = "VIndividualCustomer.findByCountryRegionName", query = "SELECT v FROM VIndividualCustomer v WHERE v.countryRegionName = :countryRegionName"),
        @NamedQuery(name = "VIndividualCustomer.findByDemographics", query = "SELECT v FROM VIndividualCustomer v WHERE v.demographics = :demographics")})
public class VIndividualCustomer implements Serializable, JsonSerializable {

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
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "PhoneNumberType")
    private String phoneNumberType;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "EmailPromotion")
    private int emailPromotion;
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
    @Column(name = "Demographics")
    private String demographics;
}
