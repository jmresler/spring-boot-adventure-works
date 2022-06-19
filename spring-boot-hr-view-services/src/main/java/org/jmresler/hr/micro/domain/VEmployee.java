package org.jmresler.hr.micro.domain;

import lombok.Data;
import org.jmresler.hr.micro.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Entity
@Table(name = "vEmployee", schema = "HumanResources")
@XmlRootElement
public class VEmployee implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Suffix")
    private String suffix;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "PhoneNumberType")
    private String phoneNumberType;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "EmailPromotion")
    private int emailPromotion;
    @Basic(optional = false)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "StateProvinceName")
    private String stateProvinceName;
    @Basic(optional = false)
    @Column(name = "PostalCode")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "CountryRegionName")
    private String countryRegionName;
    @Column(name = "AdditionalContactInfo")
    private String additionalContactInfo;

    @Transient
    public static final VEmployee EMPTY_EMPLOYEE = new VEmployee();
}
