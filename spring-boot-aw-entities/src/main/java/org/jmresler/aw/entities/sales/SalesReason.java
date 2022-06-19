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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "SalesReason", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SalesReason.selectCount", query = "SELECT COUNT(s) FROM SalesReason s"),
        @NamedQuery(name = "SalesReason.findAll", query = "SELECT s FROM SalesReason s"),
        @NamedQuery(name = "SalesReason.findBySalesReasonID", query = "SELECT s FROM SalesReason s WHERE s.salesReasonID = :salesReasonID"),
        @NamedQuery(name = "SalesReason.findByName", query = "SELECT s FROM SalesReason s WHERE s.name = :name"),
        @NamedQuery(name = "SalesReason.findByReasonType", query = "SELECT s FROM SalesReason s WHERE s.reasonType = :reasonType"),
        @NamedQuery(name = "SalesReason.findByModifiedDate", query = "SELECT s FROM SalesReason s WHERE s.modifiedDate = :modifiedDate")})
public class SalesReason implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesReasonID")
    private Integer salesReasonID;
    @Column(name = "Name")
    private String name;
    @Column(name = "ReasonType")
    private String reasonType;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesReason")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;

}
