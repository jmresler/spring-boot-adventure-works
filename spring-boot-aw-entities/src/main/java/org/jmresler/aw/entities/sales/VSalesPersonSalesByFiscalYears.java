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
@Table(name = "vSalesPersonSalesByFiscalYears", catalog = "AdventureWorks2017", schema = "Sales")
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
