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
@Table(name = "Person", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "Person.selectCount", query = "SELECT COUNT(p) FROM Person p"),
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "Person.findByBusinessEntityID", query = "SELECT p FROM Person p WHERE p.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "Person.findByPersonType", query = "SELECT p FROM Person p WHERE p.personType = :personType"),
        @NamedQuery(name = "Person.findByNameStyle", query = "SELECT p FROM Person p WHERE p.nameStyle = :nameStyle"),
        @NamedQuery(name = "Person.findByTitle", query = "SELECT p FROM Person p WHERE p.title = :title"),
        @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
        @NamedQuery(name = "Person.findByMiddleName", query = "SELECT p FROM Person p WHERE p.middleName = :middleName"),
        @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
        @NamedQuery(name = "Person.findBySuffix", query = "SELECT p FROM Person p WHERE p.suffix = :suffix"),
        @NamedQuery(name = "Person.findByEmailPromotion", query = "SELECT p FROM Person p WHERE p.emailPromotion = :emailPromotion"),
        @NamedQuery(name = "Person.findByAdditionalContactInfo", query = "SELECT p FROM Person p WHERE p.additionalContactInfo = :additionalContactInfo"),
        @NamedQuery(name = "Person.findByDemographics", query = "SELECT p FROM Person p WHERE p.demographics = :demographics"),
        @NamedQuery(name = "Person.findByRowguid", query = "SELECT p FROM Person p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "Person.findByModifiedDate", query = "SELECT p FROM Person p WHERE p.modifiedDate = :modifiedDate")})
public class Person implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "PersonType")
    private String personType;
    @Column(name = "NameStyle")
    private boolean nameStyle;
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
    @Column(name = "EmailPromotion")
    private int emailPromotion;
    @Column(name = "AdditionalContactInfo")
    private String additionalContactInfo;
    @Column(name = "Demographics")
    private String demographics;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonPhone> personPhoneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<EmailAddress> emailAddressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<BusinessEntityContact> businessEntityContactCollection;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private BusinessEntity businessEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Password password;


}
