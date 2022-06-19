package org.jmresler.hr.micro.domain;

import lombok.Data;
import org.jmresler.hr.micro.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "vJobCandidate", schema = "HumanResources")
@XmlRootElement
public class VJobCandidate implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "Prefix")
    private String prefix;
    @Column(name = "First")
    private String first;
    @Column(name = "Middle")
    private String middle;
    @Column(name = "Last")
    private String last;
    @Column(name = "Suffix")
    private String suffix;
    @Column(name = "Skills")
    private String skills;
    @Column(name = "Type")
    private String type;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "State")
    private String state;
    @Column(name = "City")
    private String city;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "EMail")
    private String eMail;
    @Column(name = "WebSite")
    private String webSite;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
