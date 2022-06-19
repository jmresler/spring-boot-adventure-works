package org.jmresler.hr.micro.domain;

import lombok.Data;
import org.jmresler.hr.micro.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "vJobCandidateEmployment", schema = "HumanResources")
@XmlRootElement
public class VJobCandidateEmployment implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "OrgName")
    private String orgName;
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "Responsibility")
    private String responsibility;
    @Column(name = "FunctionCategory")
    private String functionCategory;
    @Column(name = "IndustryCategory")
    private String industryCategory;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "State")
    private String state;
    @Column(name = "City")
    private String city;
}
