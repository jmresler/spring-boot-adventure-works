package org.jmresler.hr.aw.views.svcs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jmresler.hr.aw.views.svcs.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "View into a job candidates eduction")
@Data
@Entity
@Table(name = "vJobCandidateEducation", schema = "HumanResources")
@XmlRootElement
public class VJobCandidateEducation implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @ApiModelProperty
    @Column(name = "Level")
    private String level;
    @ApiModelProperty
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @ApiModelProperty
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @ApiModelProperty
    @Column(name = "Degree")
    private String degree;
    @ApiModelProperty
    @Column(name = "Major")
    private String major;
    @ApiModelProperty
    @Column(name = "Minor")
    private String minor;
    @ApiModelProperty
    @Column(name = "GPA")
    private String gpa;
    @ApiModelProperty
    @Column(name = "GPAScale")
    private String gPAScale;
    @ApiModelProperty
    @Column(name = "School")
    private String school;
    @ApiModelProperty
    @Column(name = "CountryRegion")
    private String countryRegion;
    @ApiModelProperty
    @Column(name = "State")
    private String state;
    @ApiModelProperty
    @Column(name = "City")
    private String city;
}
