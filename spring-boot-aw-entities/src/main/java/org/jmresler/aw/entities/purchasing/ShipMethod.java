/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.purchasing;

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
@Table(name = "ShipMethod", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
        @NamedQuery(name = "ShipMethod.selectCount", query = "SELECT COUNT(s) FROM ShipMethod s"),
        @NamedQuery(name = "ShipMethod.findAll", query = "SELECT s FROM ShipMethod s"),
        @NamedQuery(name = "ShipMethod.findByShipMethodID", query = "SELECT s FROM ShipMethod s WHERE s.shipMethodID = :shipMethodID"),
        @NamedQuery(name = "ShipMethod.findByName", query = "SELECT s FROM ShipMethod s WHERE s.name = :name"),
        @NamedQuery(name = "ShipMethod.findByShipBase", query = "SELECT s FROM ShipMethod s WHERE s.shipBase = :shipBase"),
        @NamedQuery(name = "ShipMethod.findByShipRate", query = "SELECT s FROM ShipMethod s WHERE s.shipRate = :shipRate"),
        @NamedQuery(name = "ShipMethod.findByRowguid", query = "SELECT s FROM ShipMethod s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "ShipMethod.findByModifiedDate", query = "SELECT s FROM ShipMethod s WHERE s.modifiedDate = :modifiedDate")})
public class ShipMethod implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipMethodID")
    private Integer shipMethodID;
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ShipBase")
    private BigDecimal shipBase;
    @Column(name = "ShipRate")
    private BigDecimal shipRate;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipMethodID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;

}
