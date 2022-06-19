/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

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
@Table(name = "Location", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"})})
@NamedQueries({
        @NamedQuery(name = "Location.selectCount", query = "SELECT COUNT(l) FROM Location l"),
        @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
        @NamedQuery(name = "Location.findByLocationID", query = "SELECT l FROM Location l WHERE l.locationID = :locationID"),
        @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name"),
        @NamedQuery(name = "Location.findByCostRate", query = "SELECT l FROM Location l WHERE l.costRate = :costRate"),
        @NamedQuery(name = "Location.findByAvailability", query = "SELECT l FROM Location l WHERE l.availability = :availability"),
        @NamedQuery(name = "Location.findByModifiedDate", query = "SELECT l FROM Location l WHERE l.modifiedDate = :modifiedDate")})
public class Location implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false)
    private Short locationID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CostRate", nullable = false, precision = 10, scale = 4)
    private BigDecimal costRate;
    @Column(name = "Availability", nullable = false, precision = 8, scale = 2)
    private BigDecimal availability;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<ProductInventory> productInventoryCollection;
    @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "locationID")
    private Collection<WorkOrderRouting> workOrderRoutingCollection;


}
