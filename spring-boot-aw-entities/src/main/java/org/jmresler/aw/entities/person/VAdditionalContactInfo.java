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
