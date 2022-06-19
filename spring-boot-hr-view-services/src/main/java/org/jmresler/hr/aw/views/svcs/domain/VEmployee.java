package org.jmresler.hr.aw.views.svcs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jmresler.hr.aw.views.svcs.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@ApiModel(description = "A comprehensive view into an employee")
@Data
@Entity
@Table(name = "vEmployee", schema = "HumanResources")
@XmlRootElement
public class VEmployee implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @ApiModelProperty
    @Column(name = "Title")
    private String title;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @ApiModelProperty
    @Column(name = "MiddleName")
    private String middleName;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @ApiModelProperty
    @Column(name = "Suffix")
    private String suffix;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @ApiModelProperty
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @ApiModelProperty
    @Column(name = "PhoneNumberType")
    private String phoneNumberType;
    @ApiModelProperty
    @Column(name = "EmailAddress")
    private String emailAddress;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "EmailPromotion")
    private int emailPromotion;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @ApiModelProperty
    @Column(name = "AddressLine2")
    private String addressLine2;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "StateProvinceName")
    private String stateProvinceName;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "PostalCode")
    private String postalCode;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "CountryRegionName")
    private String countryRegionName;
    @ApiModelProperty
    @Column(name = "AdditionalContactInfo")
    private String additionalContactInfo;

    @Transient
    public static final VEmployee EMPTY_EMPLOYEE = new VEmployee();
}
