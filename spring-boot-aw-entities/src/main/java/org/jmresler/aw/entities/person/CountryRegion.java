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
@Table(name = "CountryRegion", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "CountryRegion.selectCount", query = "SELECT COUNT(c) FROM CountryRegion c"),
        @NamedQuery(name = "CountryRegion.findAll", query = "SELECT c FROM CountryRegion c"),
        @NamedQuery(name = "CountryRegion.findByCountryRegionCode", query = "SELECT c FROM CountryRegion c WHERE c.countryRegionCode = :countryRegionCode"),
        @NamedQuery(name = "CountryRegion.findByName", query = "SELECT c FROM CountryRegion c WHERE c.name = :name"),
        @NamedQuery(name = "CountryRegion.findByModifiedDate", query = "SELECT c FROM CountryRegion c WHERE c.modifiedDate = :modifiedDate")})
public class CountryRegion implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Column(name = "Name")
    private String name;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryRegionCode")
    private Collection<StateProvince> stateProvinceCollection;


}
