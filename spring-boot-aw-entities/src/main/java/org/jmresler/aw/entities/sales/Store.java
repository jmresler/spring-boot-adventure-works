/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

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
@Table(name = "Store", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "Store.selectCount", query = "SELECT COUNT(s) FROM Store s"),
        @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s"),
        @NamedQuery(name = "Store.findByBusinessEntityID", query = "SELECT s FROM Store s WHERE s.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "Store.findByName", query = "SELECT s FROM Store s WHERE s.name = :name"),
        @NamedQuery(name = "Store.findByDemographics", query = "SELECT s FROM Store s WHERE s.demographics = :demographics"),
        @NamedQuery(name = "Store.findByRowguid", query = "SELECT s FROM Store s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "Store.findByModifiedDate", query = "SELECT s FROM Store s WHERE s.modifiedDate = :modifiedDate")})
public class Store implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Demographics")
    private String demographics;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "storeID")
    private Collection<Customer> customerCollection;
    @JoinColumn(name = "SalesPersonID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private SalesPerson salesPersonID;
}
