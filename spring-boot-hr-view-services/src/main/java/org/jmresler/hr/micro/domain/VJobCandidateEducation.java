package org.jmresler.hr.micro.domain;

import lombok.Data;
import org.jmresler.hr.micro.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "vJobCandidateEducation", schema = "HumanResources")
@XmlRootElement
public class VJobCandidateEducation implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @Column(name = "Level")
    private String level;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "Degree")
    private String degree;
    @Column(name = "Major")
    private String major;
    @Column(name = "Minor")
    private String minor;
    @Column(name = "GPA")
    private String gpa;
    @Column(name = "GPAScale")
    private String gPAScale;
    @Column(name = "School")
    private String school;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "State")
    private String state;
    @Column(name = "City")
    private String city;
}
