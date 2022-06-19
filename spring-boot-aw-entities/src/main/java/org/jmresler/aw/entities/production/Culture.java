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
@Table(name = "Culture", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"})})
@NamedQueries({
        @NamedQuery(name = "Culture.selectCount", query = "SELECT COUNT(c) FROM Culture c"),
        @NamedQuery(name = "Culture.findAll", query = "SELECT c FROM Culture c"),
        @NamedQuery(name = "Culture.findByCultureID", query = "SELECT c FROM Culture c WHERE c.cultureID = :cultureID"),
        @NamedQuery(name = "Culture.findByName", query = "SELECT c FROM Culture c WHERE c.name = :name"),
        @NamedQuery(name = "Culture.findByModifiedDate", query = "SELECT c FROM Culture c WHERE c.modifiedDate = :modifiedDate")})
public class Culture implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CultureID", nullable = false, length = 6)
    private String cultureID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "culture")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;


}
