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

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vStateProvinceCountryRegion", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "VStateProvinceCountryRegion.selectCount", query = "SELECT COUNT(v) FROM VStateProvinceCountryRegion v"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findAll", query = "SELECT v FROM VStateProvinceCountryRegion v"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByStateProvinceID", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.stateProvinceID = :stateProvinceID"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByStateProvinceCode", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.stateProvinceCode = :stateProvinceCode"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByIsOnlyStateProvinceFlag", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.isOnlyStateProvinceFlag = :isOnlyStateProvinceFlag"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByStateProvinceName", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.stateProvinceName = :stateProvinceName"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByTerritoryID", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.territoryID = :territoryID"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByCountryRegionCode", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.countryRegionCode = :countryRegionCode"),
        @NamedQuery(name = "VStateProvinceCountryRegion.findByCountryRegionName", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.countryRegionName = :countryRegionName")})
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
