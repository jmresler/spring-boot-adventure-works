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
@Table(name = "vSalesPersonSalesByFiscalYears", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.selectCount", query = "SELECT COUNT(v) FROM VSalesPersonSalesByFiscalYears v"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findAll", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findBySalesPersonID", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.salesPersonID = :salesPersonID"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByFullName", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.fullName = :fullName"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByJobTitle", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.jobTitle = :jobTitle"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findBySalesTerritory", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.salesTerritory = :salesTerritory"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a = :a"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA1", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a1 = :a1"),
        @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA2", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a2 = :a2")})
public class VSalesPersonSalesByFiscalYears implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "SalesPersonID")
    private Integer salesPersonID;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "SalesTerritory")
    private String salesTerritory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "2002")
    private BigDecimal a;
    @Column(name = "2003")
    private BigDecimal a1;
    @Column(name = "2004")
    private BigDecimal a2;

}
