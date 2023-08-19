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
@Table(name = "vProductModelInstructions", catalog = "AdventureWorks2017", schema = "Production")
public class VProductModelInstructions implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ProductModelID", nullable = false)
    private int productModelID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Instructions", length = 2147483647)
    private String instructions;
    @Column(name = "LocationID")
    private Integer locationID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SetupHours", precision = 9, scale = 4)
    private BigDecimal setupHours;
    @Column(name = "MachineHours", precision = 9, scale = 4)
    private BigDecimal machineHours;
    @Column(name = "LaborHours", precision = 9, scale = 4)
    private BigDecimal laborHours;
    @Column(name = "LotSize")
    private Integer lotSize;
    @Column(name = "Step", length = 1024)
    private String step;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

}
