/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.person;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vStateProvinceCountryRegion", catalog = "AdventureWorks2017", schema = "Person")
public class VStateProvinceCountryRegion implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "StateProvinceID")
    private int stateProvinceID;
    @Column(name = "StateProvinceCode")
    private String stateProvinceCode;
    @Column(name = "IsOnlyStateProvinceFlag")
    private boolean isOnlyStateProvinceFlag;
    @Column(name = "StateProvinceName")
    private String stateProvinceName;
    @Column(name = "TerritoryID")
    private int territoryID;
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Column(name = "CountryRegionName")
    private String countryRegionName;
}
