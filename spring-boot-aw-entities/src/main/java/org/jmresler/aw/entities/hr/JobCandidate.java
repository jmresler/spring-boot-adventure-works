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
@Table(name = "JobCandidate", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "JobCandidate.selectCount", query = "SELECT COUNT(j) FROM JobCandidate j"),
        @NamedQuery(name = "JobCandidate.findAll", query = "SELECT j FROM JobCandidate j"),
        @NamedQuery(name = "JobCandidate.findByJobCandidateID", query = "SELECT j FROM JobCandidate j WHERE j.jobCandidateID = :jobCandidateID"),
        @NamedQuery(name = "JobCandidate.findByResume", query = "SELECT j FROM JobCandidate j WHERE j.resume = :resume"),
        @NamedQuery(name = "JobCandidate.findByModifiedDate", query = "SELECT j FROM JobCandidate j WHERE j.modifiedDate = :modifiedDate")})
public class JobCandidate implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JobCandidateID", nullable = false)
    private Integer jobCandidateID;
    @Column(name = "Resume", length = 2147483647)
    private String resume;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private Employee businessEntityID;
}
