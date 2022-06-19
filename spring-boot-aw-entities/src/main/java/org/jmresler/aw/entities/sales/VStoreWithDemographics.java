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

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vStoreWithDemographics", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VStoreWithDemographics.selectCount", query = "SELECT COUNT(v) FROM VStoreWithDemographics v"),
        @NamedQuery(name = "VStoreWithDemographics.findAll", query = "SELECT v FROM VStoreWithDemographics v"),
        @NamedQuery(name = "VStoreWithDemographics.findByBusinessEntityID", query = "SELECT v FROM VStoreWithDemographics v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VStoreWithDemographics.findByName", query = "SELECT v FROM VStoreWithDemographics v WHERE v.name = :name"),
        @NamedQuery(name = "VStoreWithDemographics.findByAnnualSales", query = "SELECT v FROM VStoreWithDemographics v WHERE v.annualSales = :annualSales"),
        @NamedQuery(name = "VStoreWithDemographics.findByAnnualRevenue", query = "SELECT v FROM VStoreWithDemographics v WHERE v.annualRevenue = :annualRevenue"),
        @NamedQuery(name = "VStoreWithDemographics.findByBankName", query = "SELECT v FROM VStoreWithDemographics v WHERE v.bankName = :bankName"),
        @NamedQuery(name = "VStoreWithDemographics.findByBusinessType", query = "SELECT v FROM VStoreWithDemographics v WHERE v.businessType = :businessType"),
        @NamedQuery(name = "VStoreWithDemographics.findByYearOpened", query = "SELECT v FROM VStoreWithDemographics v WHERE v.yearOpened = :yearOpened"),
        @NamedQuery(name = "VStoreWithDemographics.findBySpecialty", query = "SELECT v FROM VStoreWithDemographics v WHERE v.specialty = :specialty"),
        @NamedQuery(name = "VStoreWithDemographics.findBySquareFeet", query = "SELECT v FROM VStoreWithDemographics v WHERE v.squareFeet = :squareFeet"),
        @NamedQuery(name = "VStoreWithDemographics.findByBrands", query = "SELECT v FROM VStoreWithDemographics v WHERE v.brands = :brands"),
        @NamedQuery(name = "VStoreWithDemographics.findByInternet", query = "SELECT v FROM VStoreWithDemographics v WHERE v.internet = :internet"),
        @NamedQuery(name = "VStoreWithDemographics.findByNumberEmployees", query = "SELECT v FROM VStoreWithDemographics v WHERE v.numberEmployees = :numberEmployees")})
public class VStoreWithDemographics implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AnnualSales")
    private BigDecimal annualSales;
    @Column(name = "AnnualRevenue")
    private BigDecimal annualRevenue;
    @Column(name = "BankName")
    private String bankName;
    @Column(name = "BusinessType")
    private String businessType;
    @Column(name = "YearOpened")
    private Integer yearOpened;
    @Column(name = "Specialty")
    private String specialty;
    @Column(name = "SquareFeet")
    private Integer squareFeet;
    @Column(name = "Brands")
    private String brands;
    @Column(name = "Internet")
    private String internet;
    @Column(name = "NumberEmployees")
    private Integer numberEmployees;
}
