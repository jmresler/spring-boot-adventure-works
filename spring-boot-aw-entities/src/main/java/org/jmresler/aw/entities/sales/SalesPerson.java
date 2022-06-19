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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "SalesPerson", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesPerson.selectCount", query = "SELECT COUNT(s) FROM SalesPerson s"),
        @NamedQuery(name = "SalesPerson.findAll", query = "SELECT s FROM SalesPerson s"),
        @NamedQuery(name = "SalesPerson.findByBusinessEntityID", query = "SELECT s FROM SalesPerson s WHERE s.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "SalesPerson.findBySalesQuota", query = "SELECT s FROM SalesPerson s WHERE s.salesQuota = :salesQuota"),
        @NamedQuery(name = "SalesPerson.findByBonus", query = "SELECT s FROM SalesPerson s WHERE s.bonus = :bonus"),
        @NamedQuery(name = "SalesPerson.findByCommissionPct", query = "SELECT s FROM SalesPerson s WHERE s.commissionPct = :commissionPct"),
        @NamedQuery(name = "SalesPerson.findBySalesYTD", query = "SELECT s FROM SalesPerson s WHERE s.salesYTD = :salesYTD"),
        @NamedQuery(name = "SalesPerson.findBySalesLastYear", query = "SELECT s FROM SalesPerson s WHERE s.salesLastYear = :salesLastYear"),
        @NamedQuery(name = "SalesPerson.findByRowguid", query = "SELECT s FROM SalesPerson s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesPerson.findByModifiedDate", query = "SELECT s FROM SalesPerson s WHERE s.modifiedDate = :modifiedDate")})
public class SalesPerson implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
    @Column(name = "Bonus")
    private BigDecimal bonus;
    @Column(name = "CommissionPct")
    private BigDecimal commissionPct;
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @OneToMany(mappedBy = "salesPersonID")
    private Collection<Store> storeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesPerson")
    private Collection<SalesTerritoryHistory> salesTerritoryHistoryCollection;
    @OneToMany(mappedBy = "salesPersonID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesPerson")
    private Collection<SalesPersonQuotaHistory> salesPersonQuotaHistoryCollection;
}
