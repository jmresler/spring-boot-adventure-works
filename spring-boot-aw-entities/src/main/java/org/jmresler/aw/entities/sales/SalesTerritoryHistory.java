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
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "SalesTerritoryHistory", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesTerritoryHistory.selectCount", query = "SELECT COUNT(s) FROM SalesTerritoryHistory s"),
        @NamedQuery(name = "SalesTerritoryHistory.findAll", query = "SELECT s FROM SalesTerritoryHistory s"),
        @NamedQuery(name = "SalesTerritoryHistory.findByBusinessEntityID", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "SalesTerritoryHistory.findByTerritoryID", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.territoryID = :territoryID"),
        @NamedQuery(name = "SalesTerritoryHistory.findByStartDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.startDate = :startDate"),
        @NamedQuery(name = "SalesTerritoryHistory.findByEndDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.endDate = :endDate"),
        @NamedQuery(name = "SalesTerritoryHistory.findByRowguid", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesTerritoryHistory.findByModifiedDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTerritoryHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesTerritoryHistoryPK salesTerritoryHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesPerson salesPerson;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesTerritory salesTerritory;

}
