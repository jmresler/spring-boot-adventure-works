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
@Table(name = "SalesPersonQuotaHistory", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesPersonQuotaHistory.selectCount", query = "SELECT COUNT(s) FROM SalesPersonQuotaHistory s"),
        @NamedQuery(name = "SalesPersonQuotaHistory.findAll", query = "SELECT s FROM SalesPersonQuotaHistory s"),
        @NamedQuery(name = "SalesPersonQuotaHistory.findByBusinessEntityID", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesPersonQuotaHistoryPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "SalesPersonQuotaHistory.findByQuotaDate", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesPersonQuotaHistoryPK.quotaDate = :quotaDate"),
        @NamedQuery(name = "SalesPersonQuotaHistory.findBySalesQuota", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesQuota = :salesQuota"),
        @NamedQuery(name = "SalesPersonQuotaHistory.findByRowguid", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SalesPersonQuotaHistory.findByModifiedDate", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesPersonQuotaHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesPerson salesPerson;

}
