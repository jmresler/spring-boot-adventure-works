package org.jmresler.hr.aw.views.svcs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jmresler.hr.aw.views.svcs.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "View into a job candidate")
@Data
@Entity
@Table(name = "vJobCandidate", schema = "HumanResources")
@XmlRootElement
public class VJobCandidate implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @ApiModelProperty
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @ApiModelProperty
    @Column(name = "Prefix")
    private String prefix;
    @ApiModelProperty
    @Column(name = "First")
    private String first;
    @ApiModelProperty
    @Column(name = "Middle")
    private String middle;
    @ApiModelProperty
    @Column(name = "Last")
    private String last;
    @ApiModelProperty
    @Column(name = "Suffix")
    private String suffix;
    @ApiModelProperty
    @Column(name = "Skills")
    private String skills;
    @ApiModelProperty
    @Column(name = "Type")
    private String type;
    @ApiModelProperty
    @Column(name = "CountryRegion")
    private String countryRegion;
    @ApiModelProperty
    @Column(name = "State")
    private String state;
    @ApiModelProperty
    @Column(name = "City")
    private String city;
    @ApiModelProperty
    @Column(name = "PostalCode")
    private String postalCode;
    @ApiModelProperty
    @Column(name = "EMail")
    private String eMail;
    @ApiModelProperty
    @Column(name = "WebSite")
    private String webSite;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
