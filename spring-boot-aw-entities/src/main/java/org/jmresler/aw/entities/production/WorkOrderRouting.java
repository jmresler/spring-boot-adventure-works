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
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "WorkOrderRouting", catalog = "AdventureWorks2017", schema = "Production")
public class WorkOrderRouting implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorkOrderRoutingPK workOrderRoutingPK;
    @Column(name = "ScheduledStartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledStartDate;
    @Column(name = "ScheduledEndDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledEndDate;
    @Column(name = "ActualStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualStartDate;
    @Column(name = "ActualEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEndDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ActualResourceHrs", precision = 9, scale = 4)
    private BigDecimal actualResourceHrs;
    @Column(name = "PlannedCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal plannedCost;
    @Column(name = "ActualCost", precision = 19, scale = 4)
    private BigDecimal actualCost;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", nullable = false)
    @ManyToOne(optional = false)
    private Location locationID;
    @JoinColumn(name = "WorkOrderID", referencedColumnName = "WorkOrderID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkOrder workOrder;

}
