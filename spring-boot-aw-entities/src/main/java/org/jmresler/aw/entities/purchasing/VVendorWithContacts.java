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
@Table(name = "vVendorWithContacts", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
        @NamedQuery(name = "VVendorWithContacts.selectCount", query = "SELECT COUNT(v) FROM VVendorWithContacts v"),
        @NamedQuery(name = "VVendorWithContacts.findAll", query = "SELECT v FROM VVendorWithContacts v"),
        @NamedQuery(name = "VVendorWithContacts.findByBusinessEntityID", query = "SELECT v FROM VVendorWithContacts v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VVendorWithContacts.findByName", query = "SELECT v FROM VVendorWithContacts v WHERE v.name = :name"),
        @NamedQuery(name = "VVendorWithContacts.findByContactType", query = "SELECT v FROM VVendorWithContacts v WHERE v.contactType = :contactType"),
        @NamedQuery(name = "VVendorWithContacts.findByTitle", query = "SELECT v FROM VVendorWithContacts v WHERE v.title = :title"),
        @NamedQuery(name = "VVendorWithContacts.findByFirstName", query = "SELECT v FROM VVendorWithContacts v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VVendorWithContacts.findByMiddleName", query = "SELECT v FROM VVendorWithContacts v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VVendorWithContacts.findByLastName", query = "SELECT v FROM VVendorWithContacts v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VVendorWithContacts.findBySuffix", query = "SELECT v FROM VVendorWithContacts v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VVendorWithContacts.findByPhoneNumber", query = "SELECT v FROM VVendorWithContacts v WHERE v.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "VVendorWithContacts.findByPhoneNumberType", query = "SELECT v FROM VVendorWithContacts v WHERE v.phoneNumberType = :phoneNumberType"),
        @NamedQuery(name = "VVendorWithContacts.findByEmailAddress", query = "SELECT v FROM VVendorWithContacts v WHERE v.emailAddress = :emailAddress"),
        @NamedQuery(name = "VVendorWithContacts.findByEmailPromotion", query = "SELECT v FROM VVendorWithContacts v WHERE v.emailPromotion = :emailPromotion")})
public class VVendorWithContacts implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Name")
    private String name;
    @Column(name = "ContactType")
    private String contactType;
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

}
