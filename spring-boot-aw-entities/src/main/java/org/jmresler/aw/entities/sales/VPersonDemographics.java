/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vPersonDemographics", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VPersonDemographics.selectCount", query = "SELECT COUNT(v) FROM VPersonDemographics v"),
        @NamedQuery(name = "VPersonDemographics.findAll", query = "SELECT v FROM VPersonDemographics v"),
        @NamedQuery(name = "VPersonDemographics.findByBusinessEntityID", query = "SELECT v FROM VPersonDemographics v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VPersonDemographics.findByTotalPurchaseYTD", query = "SELECT v FROM VPersonDemographics v WHERE v.totalPurchaseYTD = :totalPurchaseYTD"),
        @NamedQuery(name = "VPersonDemographics.findByDateFirstPurchase", query = "SELECT v FROM VPersonDemographics v WHERE v.dateFirstPurchase = :dateFirstPurchase"),
        @NamedQuery(name = "VPersonDemographics.findByBirthDate", query = "SELECT v FROM VPersonDemographics v WHERE v.birthDate = :birthDate"),
        @NamedQuery(name = "VPersonDemographics.findByMaritalStatus", query = "SELECT v FROM VPersonDemographics v WHERE v.maritalStatus = :maritalStatus"),
        @NamedQuery(name = "VPersonDemographics.findByYearlyIncome", query = "SELECT v FROM VPersonDemographics v WHERE v.yearlyIncome = :yearlyIncome"),
        @NamedQuery(name = "VPersonDemographics.findByGender", query = "SELECT v FROM VPersonDemographics v WHERE v.gender = :gender"),
        @NamedQuery(name = "VPersonDemographics.findByTotalChildren", query = "SELECT v FROM VPersonDemographics v WHERE v.totalChildren = :totalChildren"),
        @NamedQuery(name = "VPersonDemographics.findByNumberChildrenAtHome", query = "SELECT v FROM VPersonDemographics v WHERE v.numberChildrenAtHome = :numberChildrenAtHome"),
        @NamedQuery(name = "VPersonDemographics.findByEducation", query = "SELECT v FROM VPersonDemographics v WHERE v.education = :education"),
        @NamedQuery(name = "VPersonDemographics.findByOccupation", query = "SELECT v FROM VPersonDemographics v WHERE v.occupation = :occupation"),
        @NamedQuery(name = "VPersonDemographics.findByHomeOwnerFlag", query = "SELECT v FROM VPersonDemographics v WHERE v.homeOwnerFlag = :homeOwnerFlag"),
        @NamedQuery(name = "VPersonDemographics.findByNumberCarsOwned", query = "SELECT v FROM VPersonDemographics v WHERE v.numberCarsOwned = :numberCarsOwned")})
public class VPersonDemographics implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalPurchaseYTD")
    private BigDecimal totalPurchaseYTD;
    @Column(name = "DateFirstPurchase")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFirstPurchase;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "MaritalStatus")
    private String maritalStatus;
    @Column(name = "YearlyIncome")
    private String yearlyIncome;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "TotalChildren")
    private Integer totalChildren;
    @Column(name = "NumberChildrenAtHome")
    private Integer numberChildrenAtHome;
    @Column(name = "Education")
    private String education;
    @Column(name = "Occupation")
    private String occupation;
    @Column(name = "HomeOwnerFlag")
    private Boolean homeOwnerFlag;
    @Column(name = "NumberCarsOwned")
    private Integer numberCarsOwned;

}
