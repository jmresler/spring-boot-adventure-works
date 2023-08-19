/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.hr;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vJobCandidateEmployment", catalog = "AdventureWorks2017", schema = "HumanResources")
public class VJobCandidateEmployment implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "JobCandidateID", nullable = false)
    private int jobCandidateID;
    @Column(name = "\"Emp.StartDate\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "\"Emp.EndDate\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "\"Emp.OrgName\"", length = 100)
    private String orgName;
    @Column(name = "\"Emp.JobTitle\"", length = 100)
    private String jobTitle;
    @Column(name = "\"Emp.Responsibility\"", length = 2147483647)
    private String responsibility;
    @Column(name = "\"Emp.FunctionCategory\"", length = 2147483647)
    private String functionCategory;
    @Column(name = "\"Emp.IndustryCategory\"", length = 2147483647)
    private String industryCategory;
    @Column(name = "\"Emp.Loc.CountryRegion\"", length = 2147483647)
    private String countryRegion;
    @Column(name = "\"Emp.Loc.State\"", length = 2147483647)
    private String state;
    @Column(name = "\"Emp.Loc.City\"", length = 2147483647)
    private String city;
}
