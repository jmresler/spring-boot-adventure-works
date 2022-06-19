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
@Table(name = "vStoreWithContacts", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VStoreWithContacts.selectCount", query = "SELECT COUNT(v) FROM VStoreWithContacts v"),
        @NamedQuery(name = "VStoreWithContacts.findAll", query = "SELECT v FROM VStoreWithContacts v"),
        @NamedQuery(name = "VStoreWithContacts.findByBusinessEntityID", query = "SELECT v FROM VStoreWithContacts v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VStoreWithContacts.findByName", query = "SELECT v FROM VStoreWithContacts v WHERE v.name = :name"),
        @NamedQuery(name = "VStoreWithContacts.findByContactType", query = "SELECT v FROM VStoreWithContacts v WHERE v.contactType = :contactType"),
        @NamedQuery(name = "VStoreWithContacts.findByTitle", query = "SELECT v FROM VStoreWithContacts v WHERE v.title = :title"),
        @NamedQuery(name = "VStoreWithContacts.findByFirstName", query = "SELECT v FROM VStoreWithContacts v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VStoreWithContacts.findByMiddleName", query = "SELECT v FROM VStoreWithContacts v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VStoreWithContacts.findByLastName", query = "SELECT v FROM VStoreWithContacts v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VStoreWithContacts.findBySuffix", query = "SELECT v FROM VStoreWithContacts v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VStoreWithContacts.findByPhoneNumber", query = "SELECT v FROM VStoreWithContacts v WHERE v.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "VStoreWithContacts.findByPhoneNumberType", query = "SELECT v FROM VStoreWithContacts v WHERE v.phoneNumberType = :phoneNumberType"),
        @NamedQuery(name = "VStoreWithContacts.findByEmailAddress", query = "SELECT v FROM VStoreWithContacts v WHERE v.emailAddress = :emailAddress"),
        @NamedQuery(name = "VStoreWithContacts.findByEmailPromotion", query = "SELECT v FROM VStoreWithContacts v WHERE v.emailPromotion = :emailPromotion")})
public class VStoreWithContacts implements Serializable, JsonSerializable {

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
