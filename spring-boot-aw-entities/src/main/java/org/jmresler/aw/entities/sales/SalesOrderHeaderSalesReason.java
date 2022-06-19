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
@Table(name = "SalesOrderHeaderSalesReason", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesOrderHeaderSalesReason.selectCount", query = "SELECT COUNT(s) FROM SalesOrderHeaderSalesReason s"),
        @NamedQuery(name = "SalesOrderHeaderSalesReason.findAll", query = "SELECT s FROM SalesOrderHeaderSalesReason s"),
        @NamedQuery(name = "SalesOrderHeaderSalesReason.findBySalesOrderID", query = "SELECT s FROM SalesOrderHeaderSalesReason s WHERE s.salesOrderHeaderSalesReasonPK.salesOrderID = :salesOrderID"),
        @NamedQuery(name = "SalesOrderHeaderSalesReason.findBySalesReasonID", query = "SELECT s FROM SalesOrderHeaderSalesReason s WHERE s.salesOrderHeaderSalesReasonPK.salesReasonID = :salesReasonID"),
        @NamedQuery(name = "SalesOrderHeaderSalesReason.findByModifiedDate", query = "SELECT s FROM SalesOrderHeaderSalesReason s WHERE s.modifiedDate = :modifiedDate")})
public class SalesOrderHeaderSalesReason implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesOrderHeaderSalesReasonPK salesOrderHeaderSalesReasonPK;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    @JoinColumn(name = "SalesReasonID", referencedColumnName = "SalesReasonID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesReason salesReason;

}
