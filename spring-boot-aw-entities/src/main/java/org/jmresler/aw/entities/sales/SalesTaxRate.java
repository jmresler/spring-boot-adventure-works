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
@Table(name = "SalesTaxRate", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesTaxRate.selectCount", query = "SELECT COUNT(s) FROM SalesTaxRate s"),
        @NamedQuery(name = "SalesTaxRate.findAll", query = "SELECT s FROM SalesTaxRate s"),
        @NamedQuery(name = "SalesTaxRate.findBySalesTaxRateID", query = "SELECT s FROM SalesTaxRate s WHERE s.salesTaxRateID = :salesTaxRateID"),
        @NamedQuery(name = "SalesTaxRate.findByStateProvinceID", query = "SELECT s FROM SalesTaxRate s WHERE s.stateProvinceID = :stateProvinceID"),
        @NamedQuery(name = "SalesTaxRate.findByTaxType", query = "SELECT s FROM SalesTaxRate s WHERE s.taxType = :taxType"),
        @NamedQuery(name = "SalesTaxRate.findByTaxRate", query = "SELECT s FROM SalesTaxRate s WHERE s.taxRate = :taxRate"),
        @NamedQuery(name = "SalesTaxRate.findByName", query = "SELECT s FROM SalesTaxRate s WHERE s.name = :name"),
        @NamedQuery(name = "SalesTaxRate.findByRowguid", query = "SELECT s FROM SalesTaxRate s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesTaxRate.findByModifiedDate", query = "SELECT s FROM SalesTaxRate s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTaxRate implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesTaxRateID")
    private Integer salesTaxRateID;
    @Column(name = "StateProvinceID")
    private int stateProvinceID;
    @Column(name = "TaxType")
    private short taxType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TaxRate")
    private BigDecimal taxRate;
    @Column(name = "Name")
    private String name;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
