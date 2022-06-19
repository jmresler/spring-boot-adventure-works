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
@Table(name = "SalesTerritory", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesTerritory.selectCount", query = "SELECT COUNT(s) FROM SalesTerritory s"),
        @NamedQuery(name = "SalesTerritory.findAll", query = "SELECT s FROM SalesTerritory s"),
        @NamedQuery(name = "SalesTerritory.findByTerritoryID", query = "SELECT s FROM SalesTerritory s WHERE s.territoryID = :territoryID"),
        @NamedQuery(name = "SalesTerritory.findByName", query = "SELECT s FROM SalesTerritory s WHERE s.name = :name"),
        @NamedQuery(name = "SalesTerritory.findByCountryRegionCode", query = "SELECT s FROM SalesTerritory s WHERE s.countryRegionCode = :countryRegionCode"),
        @NamedQuery(name = "SalesTerritory.findByGroup", query = "SELECT s FROM SalesTerritory s WHERE s.group = :group"),
        @NamedQuery(name = "SalesTerritory.findBySalesYTD", query = "SELECT s FROM SalesTerritory s WHERE s.salesYTD = :salesYTD"),
        @NamedQuery(name = "SalesTerritory.findBySalesLastYear", query = "SELECT s FROM SalesTerritory s WHERE s.salesLastYear = :salesLastYear"),
        @NamedQuery(name = "SalesTerritory.findByCostYTD", query = "SELECT s FROM SalesTerritory s WHERE s.costYTD = :costYTD"),
        @NamedQuery(name = "SalesTerritory.findByCostLastYear", query = "SELECT s FROM SalesTerritory s WHERE s.costLastYear = :costLastYear"),
        @NamedQuery(name = "SalesTerritory.findByRowguid", query = "SELECT s FROM SalesTerritory s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesTerritory.findByModifiedDate", query = "SELECT s FROM SalesTerritory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTerritory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TerritoryID")
    private Integer territoryID;
    @Column(name = "Name")
    private String name;
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Column(name = "\"Group\"")
    private String group;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
    @Column(name = "CostYTD")
    private BigDecimal costYTD;
    @Column(name = "CostLastYear")
    private BigDecimal costLastYear;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "territoryID")
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "territoryID")
    private Collection<SalesPerson> salesPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesTerritory")
    private Collection<SalesTerritoryHistory> salesTerritoryHistoryCollection;
    @OneToMany(mappedBy = "territoryID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

}
