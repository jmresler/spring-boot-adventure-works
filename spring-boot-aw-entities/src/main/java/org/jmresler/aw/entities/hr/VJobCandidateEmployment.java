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
@NamedQueries({
        @NamedQuery(name = "VJobCandidateEmployment.selectCount", query = "SELECT COUNT(v) FROM VJobCandidateEmployment v"),
        @NamedQuery(name = "VJobCandidateEmployment.findAll", query = "SELECT v FROM VJobCandidateEmployment v"),
        @NamedQuery(name = "VJobCandidateEmployment.findByJobCandidateID", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.jobCandidateID = :jobCandidateID"),
        @NamedQuery(name = "VJobCandidateEmployment.findByStartDate", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.startDate = :startDate"),
        @NamedQuery(name = "VJobCandidateEmployment.findByEndDate", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.endDate = :endDate"),
        @NamedQuery(name = "VJobCandidateEmployment.findByOrgName", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.orgName = :orgName"),
        @NamedQuery(name = "VJobCandidateEmployment.findByJobTitle", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.jobTitle = :jobTitle"),
        @NamedQuery(name = "VJobCandidateEmployment.findByResponsibility", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.responsibility = :responsibility"),
        @NamedQuery(name = "VJobCandidateEmployment.findByFunctionCategory", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.functionCategory = :functionCategory"),
        @NamedQuery(name = "VJobCandidateEmployment.findByIndustryCategory", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.industryCategory = :industryCategory"),
        @NamedQuery(name = "VJobCandidateEmployment.findByCountryRegion", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.countryRegion = :countryRegion"),
        @NamedQuery(name = "VJobCandidateEmployment.findByState", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.state = :state"),
        @NamedQuery(name = "VJobCandidateEmployment.findByCity", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.city = :city")})
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
