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
@Table(name = "BusinessEntity", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "BusinessEntity.selectCount", query = "SELECT COUNT(b) FROM BusinessEntity b"),
        @NamedQuery(name = "BusinessEntity.findAll", query = "SELECT b FROM BusinessEntity b"),
        @NamedQuery(name = "BusinessEntity.findByBusinessEntityID", query = "SELECT b FROM BusinessEntity b WHERE b.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "BusinessEntity.findByRowguid", query = "SELECT b FROM BusinessEntity b WHERE b.rowguid = :rowguid"),
        @NamedQuery(name = "BusinessEntity.findByModifiedDate", query = "SELECT b FROM BusinessEntity b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntity implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Collection<BusinessEntityContact> businessEntityContactCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Person person;

}
