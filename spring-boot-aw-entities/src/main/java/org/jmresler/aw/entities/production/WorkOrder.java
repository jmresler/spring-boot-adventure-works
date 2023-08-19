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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "WorkOrder", catalog = "AdventureWorks2017", schema = "Production")
public class WorkOrder implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkOrderID", nullable = false)
    private Integer workOrderID;
    @Column(name = "OrderQty", nullable = false)
    private int orderQty;
    @Column(name = "StockedQty", nullable = false)
    private int stockedQty;
    @Column(name = "ScrappedQty", nullable = false)
    private short scrappedQty;
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "DueDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workOrder")
    private Collection<WorkOrderRouting> workOrderRoutingCollection;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product productID;
    @JoinColumn(name = "ScrapReasonID", referencedColumnName = "ScrapReasonID")
    @ManyToOne
    private ScrapReason scrapReasonID;

}
