package org.jmresler.hr.aw.views.svcs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jmresler.hr.aw.views.svcs.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "View into a job candidates employment")
@Data
@Entity
@Table(name = "vJobCandidateEmployment", schema = "HumanResources")
@XmlRootElement
public class VJobCandidateEmployment implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @ApiModelProperty
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @ApiModelProperty
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @ApiModelProperty
    @Column(name = "OrgName")
    private String orgName;
    @ApiModelProperty
    @Column(name = "JobTitle")
    private String jobTitle;
    @ApiModelProperty
    @Column(name = "Responsibility")
    private String responsibility;
    @ApiModelProperty
    @Column(name = "FunctionCategory")
    private String functionCategory;
    @ApiModelProperty
    @Column(name = "IndustryCategory")
    private String industryCategory;
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
