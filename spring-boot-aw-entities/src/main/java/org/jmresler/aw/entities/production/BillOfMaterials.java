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
@Table(name = "BillOfMaterials", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ProductAssemblyID", "ComponentID", "StartDate"})})
@NamedQueries({
        @NamedQuery(name = "BillOfMaterials.selectCount", query = "SELECT COUNT(b) FROM BillOfMaterials b"),
        @NamedQuery(name = "BillOfMaterials.findAll", query = "SELECT b FROM BillOfMaterials b"),
        @NamedQuery(name = "BillOfMaterials.findByBillOfMaterialsID", query = "SELECT b FROM BillOfMaterials b WHERE b.billOfMaterialsID = :billOfMaterialsID"),
        @NamedQuery(name = "BillOfMaterials.findByStartDate", query = "SELECT b FROM BillOfMaterials b WHERE b.startDate = :startDate"),
        @NamedQuery(name = "BillOfMaterials.findByEndDate", query = "SELECT b FROM BillOfMaterials b WHERE b.endDate = :endDate"),
        @NamedQuery(name = "BillOfMaterials.findByBOMLevel", query = "SELECT b FROM BillOfMaterials b WHERE b.bOMLevel = :bOMLevel"),
        @NamedQuery(name = "BillOfMaterials.findByPerAssemblyQty", query = "SELECT b FROM BillOfMaterials b WHERE b.perAssemblyQty = :perAssemblyQty"),
        @NamedQuery(name = "BillOfMaterials.findByModifiedDate", query = "SELECT b FROM BillOfMaterials b WHERE b.modifiedDate = :modifiedDate")})
public class BillOfMaterials implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BillOfMaterialsID", nullable = false)
    private Integer billOfMaterialsID;
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "BOMLevel", nullable = false)
    private short bOMLevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PerAssemblyQty", nullable = false, precision = 8, scale = 2)
    private BigDecimal perAssemblyQty;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductAssemblyID", referencedColumnName = "ProductID")
    @ManyToOne
    private Product productAssemblyID;
    @JoinColumn(name = "ComponentID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product componentID;
    @JoinColumn(name = "UnitMeasureCode", referencedColumnName = "UnitMeasureCode", nullable = false)
    @ManyToOne(optional = false)
    private UnitMeasure unitMeasureCode;


}
