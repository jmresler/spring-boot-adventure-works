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
@Table(name = "vJobCandidateEducation", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "VJobCandidateEducation.selectCount", query = "SELECT COUNT(v) FROM VJobCandidateEducation v"),
        @NamedQuery(name = "VJobCandidateEducation.findAll", query = "SELECT v FROM VJobCandidateEducation v"),
        @NamedQuery(name = "VJobCandidateEducation.findByJobCandidateID", query = "SELECT v FROM VJobCandidateEducation v WHERE v.jobCandidateID = :jobCandidateID"),
        @NamedQuery(name = "VJobCandidateEducation.findByLevel", query = "SELECT v FROM VJobCandidateEducation v WHERE v.level = :level"),
        @NamedQuery(name = "VJobCandidateEducation.findByStartDate", query = "SELECT v FROM VJobCandidateEducation v WHERE v.startDate = :startDate"),
        @NamedQuery(name = "VJobCandidateEducation.findByEndDate", query = "SELECT v FROM VJobCandidateEducation v WHERE v.endDate = :endDate"),
        @NamedQuery(name = "VJobCandidateEducation.findByDegree", query = "SELECT v FROM VJobCandidateEducation v WHERE v.degree = :degree"),
        @NamedQuery(name = "VJobCandidateEducation.findByMajor", query = "SELECT v FROM VJobCandidateEducation v WHERE v.major = :major"),
        @NamedQuery(name = "VJobCandidateEducation.findByMinor", query = "SELECT v FROM VJobCandidateEducation v WHERE v.minor = :minor"),
        @NamedQuery(name = "VJobCandidateEducation.findByGpa", query = "SELECT v FROM VJobCandidateEducation v WHERE v.gpa = :gpa"),
        @NamedQuery(name = "VJobCandidateEducation.findByGPAScale", query = "SELECT v FROM VJobCandidateEducation v WHERE v.gPAScale = :gPAScale"),
        @NamedQuery(name = "VJobCandidateEducation.findBySchool", query = "SELECT v FROM VJobCandidateEducation v WHERE v.school = :school"),
        @NamedQuery(name = "VJobCandidateEducation.findByCountryRegion", query = "SELECT v FROM VJobCandidateEducation v WHERE v.countryRegion = :countryRegion"),
        @NamedQuery(name = "VJobCandidateEducation.findByState", query = "SELECT v FROM VJobCandidateEducation v WHERE v.state = :state"),
        @NamedQuery(name = "VJobCandidateEducation.findByCity", query = "SELECT v FROM VJobCandidateEducation v WHERE v.city = :city")})
public class VJobCandidateEducation implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "JobCandidateID", nullable = false)
    private int jobCandidateID;
    @Column(name = "\"Edu.Level\"", length = 2147483647)
    private String level;
    @Column(name = "\"Edu.StartDate\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "\"Edu.EndDate\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "\"Edu.Degree\"", length = 50)
    private String degree;
    @Column(name = "\"Edu.Major\"", length = 50)
    private String major;
    @Column(name = "\"Edu.Minor\"", length = 50)
    private String minor;
    @Column(name = "\"Edu.GPA\"", length = 5)
    private String gpa;
    @Column(name = "\"Edu.GPAScale\"", length = 5)
    private String gPAScale;
    @Column(name = "\"Edu.School\"", length = 100)
    private String school;
    @Column(name = "\"Edu.loc.CountryRegion\"", length = 100)
    private String countryRegion;
    @Column(name = "\"Edu.loc.State\"", length = 100)
    private String state;
    @Column(name = "\"Edu.loc.City\"", length = 100)
    private String city;
}
