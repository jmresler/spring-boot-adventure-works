/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.person;

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
@Table(name = "StateProvince", catalog = "AdventureWorks2017", schema = "Person")
public class StateProvince implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StateProvinceID")
    private Integer stateProvinceID;
    @Column(name = "StateProvinceCode")
    private String stateProvinceCode;
    @Column(name = "IsOnlyStateProvinceFlag")
    private boolean isOnlyStateProvinceFlag;
    @Column(name = "Name")
    private String name;
    @Column(name = "TerritoryID")
    private int territoryID;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateProvinceID")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "CountryRegionCode", referencedColumnName = "CountryRegionCode")
    @ManyToOne(optional = false)
    private CountryRegion countryRegionCode;


}
