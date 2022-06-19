/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.hr;

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
@Table(name = "vEmployee", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "VEmployee.selectCount", query = "SELECT COUNT(v) FROM VEmployee v"),
        @NamedQuery(name = "VEmployee.findAll", query = "SELECT v FROM VEmployee v"),
        @NamedQuery(name = "VEmployee.findByBusinessEntityID", query = "SELECT v FROM VEmployee v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VEmployee.findByTitle", query = "SELECT v FROM VEmployee v WHERE v.title = :title"),
        @NamedQuery(name = "VEmployee.findByFirstName", query = "SELECT v FROM VEmployee v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VEmployee.findByMiddleName", query = "SELECT v FROM VEmployee v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VEmployee.findByLastName", query = "SELECT v FROM VEmployee v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VEmployee.findBySuffix", query = "SELECT v FROM VEmployee v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VEmployee.findByJobTitle", query = "SELECT v FROM VEmployee v WHERE v.jobTitle = :jobTitle"),
        @NamedQuery(name = "VEmployee.findByPhoneNumber", query = "SELECT v FROM VEmployee v WHERE v.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "VEmployee.findByPhoneNumberType", query = "SELECT v FROM VEmployee v WHERE v.phoneNumberType = :phoneNumberType"),
        @NamedQuery(name = "VEmployee.findByEmailAddress", query = "SELECT v FROM VEmployee v WHERE v.emailAddress = :emailAddress"),
        @NamedQuery(name = "VEmployee.findByEmailPromotion", query = "SELECT v FROM VEmployee v WHERE v.emailPromotion = :emailPromotion"),
        @NamedQuery(name = "VEmployee.findByAddressLine1", query = "SELECT v FROM VEmployee v WHERE v.addressLine1 = :addressLine1"),
        @NamedQuery(name = "VEmployee.findByAddressLine2", query = "SELECT v FROM VEmployee v WHERE v.addressLine2 = :addressLine2"),
        @NamedQuery(name = "VEmployee.findByCity", query = "SELECT v FROM VEmployee v WHERE v.city = :city"),
        @NamedQuery(name = "VEmployee.findByStateProvinceName", query = "SELECT v FROM VEmployee v WHERE v.stateProvinceName = :stateProvinceName"),
        @NamedQuery(name = "VEmployee.findByPostalCode", query = "SELECT v FROM VEmployee v WHERE v.postalCode = :postalCode"),
        @NamedQuery(name = "VEmployee.findByCountryRegionName", query = "SELECT v FROM VEmployee v WHERE v.countryRegionName = :countryRegionName"),
        @NamedQuery(name = "VEmployee.findByAdditionalContactInfo", query = "SELECT v FROM VEmployee v WHERE v.additionalContactInfo = :additionalContactInfo")})
public class VEmployee implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "Title", length = 8)
    private String title;
    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "MiddleName", length = 50)
    private String middleName;
    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "Suffix", length = 10)
    private String suffix;
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
    @Column(name = "PhoneNumber", length = 25)
    private String phoneNumber;
    @Column(name = "PhoneNumberType", length = 50)
    private String phoneNumberType;
    @Column(name = "EmailAddress", length = 50)
    private String emailAddress;
    @Column(name = "EmailPromotion", nullable = false)
    private int emailPromotion;
    @Column(name = "AddressLine1", nullable = false, length = 60)
    private String addressLine1;
    @Column(name = "AddressLine2", length = 60)
    private String addressLine2;
    @Column(name = "City", nullable = false, length = 30)
    private String city;
    @Column(name = "StateProvinceName", nullable = false, length = 50)
    private String stateProvinceName;
    @Column(name = "PostalCode", nullable = false, length = 15)
    private String postalCode;
    @Column(name = "CountryRegionName", nullable = false, length = 50)
    private String countryRegionName;
    @Column(name = "AdditionalContactInfo", length = 2147483647)
    private String additionalContactInfo;

}
