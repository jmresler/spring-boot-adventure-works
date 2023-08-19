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
@Table(name = "vJobCandidate", catalog = "AdventureWorks2017", schema = "HumanResources")
public class VJobCandidate implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "JobCandidateID", nullable = false)
    private int jobCandidateID;
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "\"Name.Prefix\"", length = 30)
    private String prefix;
    @Column(name = "\"Name.First\"", length = 30)
    private String first;
    @Column(name = "\"Name.Middle\"", length = 30)
    private String middle;
    @Column(name = "\"Name.Last\"", length = 30)
    private String last;
    @Column(name = "\"Name.Suffix\"", length = 30)
    private String suffix;
    @Column(name = "Skills", length = 2147483647)
    private String skills;
    @Column(name = "\"Addr.Type\"", length = 30)
    private String type;
    @Column(name = "\"Addr.Loc.CountryRegion\"", length = 100)
    private String countryRegion;
    @Column(name = "\"Addr.Loc.State\"", length = 100)
    private String state;
    @Column(name = "\"Addr.Loc.City\"", length = 100)
    private String city;
    @Column(name = "\"Addr.PostalCode\"", length = 20)
    private String postalCode;
    @Column(name = "EMail", length = 2147483647)
    private String eMail;
    @Column(name = "WebSite", length = 2147483647)
    private String webSite;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
