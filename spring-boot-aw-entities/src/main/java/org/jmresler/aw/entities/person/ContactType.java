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
@Table(name = "ContactType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "ContactType.selectCount", query = "SELECT COUNT(c) FROM ContactType c"),
        @NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c"),
        @NamedQuery(name = "ContactType.findByContactTypeID", query = "SELECT c FROM ContactType c WHERE c.contactTypeID = :contactTypeID"),
        @NamedQuery(name = "ContactType.findByName", query = "SELECT c FROM ContactType c WHERE c.name = :name"),
        @NamedQuery(name = "ContactType.findByModifiedDate", query = "SELECT c FROM ContactType c WHERE c.modifiedDate = :modifiedDate")})
public class ContactType implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContactTypeID")
    private Integer contactTypeID;
    @Column(name = "Name")
    private String name;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactType")
    private Collection<BusinessEntityContact> businessEntityContactCollection;

}
