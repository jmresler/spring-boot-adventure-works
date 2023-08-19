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
@Table(name = "UnitMeasure", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"})})
public class UnitMeasure implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "UnitMeasureCode", nullable = false, length = 3)
    private String unitMeasureCode;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "sizeUnitMeasureCode")
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "weightUnitMeasureCode")
    private Collection<Product> productCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitMeasureCode")
    private Collection<BillOfMaterials> billOfMaterialsCollection;

}
