/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
