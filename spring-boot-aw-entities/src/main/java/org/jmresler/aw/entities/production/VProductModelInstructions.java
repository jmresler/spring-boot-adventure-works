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
@NamedQueries({
        @NamedQuery(name = "VProductModelInstructions.selectCount", query = "SELECT COUNT(v) FROM VProductModelInstructions v"),
        @NamedQuery(name = "VProductModelInstructions.findAll", query = "SELECT v FROM VProductModelInstructions v"),
        @NamedQuery(name = "VProductModelInstructions.findByProductModelID", query = "SELECT v FROM VProductModelInstructions v WHERE v.productModelID = :productModelID"),
        @NamedQuery(name = "VProductModelInstructions.findByName", query = "SELECT v FROM VProductModelInstructions v WHERE v.name = :name"),
        @NamedQuery(name = "VProductModelInstructions.findByInstructions", query = "SELECT v FROM VProductModelInstructions v WHERE v.instructions = :instructions"),
        @NamedQuery(name = "VProductModelInstructions.findByLocationID", query = "SELECT v FROM VProductModelInstructions v WHERE v.locationID = :locationID"),
        @NamedQuery(name = "VProductModelInstructions.findBySetupHours", query = "SELECT v FROM VProductModelInstructions v WHERE v.setupHours = :setupHours"),
        @NamedQuery(name = "VProductModelInstructions.findByMachineHours", query = "SELECT v FROM VProductModelInstructions v WHERE v.machineHours = :machineHours"),
        @NamedQuery(name = "VProductModelInstructions.findByLaborHours", query = "SELECT v FROM VProductModelInstructions v WHERE v.laborHours = :laborHours"),
        @NamedQuery(name = "VProductModelInstructions.findByLotSize", query = "SELECT v FROM VProductModelInstructions v WHERE v.lotSize = :lotSize"),
        @NamedQuery(name = "VProductModelInstructions.findByStep", query = "SELECT v FROM VProductModelInstructions v WHERE v.step = :step"),
        @NamedQuery(name = "VProductModelInstructions.findByRowguid", query = "SELECT v FROM VProductModelInstructions v WHERE v.rowguid = :rowguid"),
        @NamedQuery(name = "VProductModelInstructions.findByModifiedDate", query = "SELECT v FROM VProductModelInstructions v WHERE v.modifiedDate = :modifiedDate")})
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
