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
@Table(name = "vAdditionalContactInfo", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "VAdditionalContactInfo.selectCount", query = "SELECT COUNT(v) FROM VAdditionalContactInfo v"),
        @NamedQuery(name = "VAdditionalContactInfo.findAll", query = "SELECT v FROM VAdditionalContactInfo v"),
        @NamedQuery(name = "VAdditionalContactInfo.findByBusinessEntityID", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VAdditionalContactInfo.findByFirstName", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VAdditionalContactInfo.findByMiddleName", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VAdditionalContactInfo.findByLastName", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VAdditionalContactInfo.findByTelephoneNumber", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.telephoneNumber = :telephoneNumber"),
        @NamedQuery(name = "VAdditionalContactInfo.findByTelephoneSpecialInstructions", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.telephoneSpecialInstructions = :telephoneSpecialInstructions"),
        @NamedQuery(name = "VAdditionalContactInfo.findByStreet", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.street = :street"),
        @NamedQuery(name = "VAdditionalContactInfo.findByCity", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.city = :city"),
        @NamedQuery(name = "VAdditionalContactInfo.findByStateProvince", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.stateProvince = :stateProvince"),
        @NamedQuery(name = "VAdditionalContactInfo.findByPostalCode", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.postalCode = :postalCode"),
        @NamedQuery(name = "VAdditionalContactInfo.findByCountryRegion", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.countryRegion = :countryRegion"),
        @NamedQuery(name = "VAdditionalContactInfo.findByHomeAddressSpecialInstructions", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.homeAddressSpecialInstructions = :homeAddressSpecialInstructions"),
        @NamedQuery(name = "VAdditionalContactInfo.findByEMailAddress", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.eMailAddress = :eMailAddress"),
        @NamedQuery(name = "VAdditionalContactInfo.findByEMailSpecialInstructions", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.eMailSpecialInstructions = :eMailSpecialInstructions"),
        @NamedQuery(name = "VAdditionalContactInfo.findByEMailTelephoneNumber", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.eMailTelephoneNumber = :eMailTelephoneNumber"),
        @NamedQuery(name = "VAdditionalContactInfo.findByRowguid", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.rowguid = :rowguid"),
        @NamedQuery(name = "VAdditionalContactInfo.findByModifiedDate", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.modifiedDate = :modifiedDate")})
public class VAdditionalContactInfo implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "TelephoneNumber")
    private String telephoneNumber;
    @Column(name = "TelephoneSpecialInstructions")
    private String telephoneSpecialInstructions;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;
    @Column(name = "StateProvince")
    private String stateProvince;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "HomeAddressSpecialInstructions")
    private String homeAddressSpecialInstructions;
    @Column(name = "EMailAddress")
    private String eMailAddress;
    @Column(name = "EMailSpecialInstructions")
    private String eMailSpecialInstructions;
    @Column(name = "EMailTelephoneNumber")
    private String eMailTelephoneNumber;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;


}
