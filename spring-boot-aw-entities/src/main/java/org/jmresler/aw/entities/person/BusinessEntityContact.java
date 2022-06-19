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
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "BusinessEntityContact", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "BusinessEntityContact.selectCount", query = "SELECT COUNT(b) FROM BusinessEntityContact b"),
        @NamedQuery(name = "BusinessEntityContact.findAll", query = "SELECT b FROM BusinessEntityContact b"),
        @NamedQuery(name = "BusinessEntityContact.findByBusinessEntityID", query = "SELECT b FROM BusinessEntityContact b WHERE b.businessEntityContactPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "BusinessEntityContact.findByPersonID", query = "SELECT b FROM BusinessEntityContact b WHERE b.businessEntityContactPK.personID = :personID"),
        @NamedQuery(name = "BusinessEntityContact.findByContactTypeID", query = "SELECT b FROM BusinessEntityContact b WHERE b.businessEntityContactPK.contactTypeID = :contactTypeID"),
        @NamedQuery(name = "BusinessEntityContact.findByRowguid", query = "SELECT b FROM BusinessEntityContact b WHERE b.rowguid = :rowguid"),
        @NamedQuery(name = "BusinessEntityContact.findByModifiedDate", query = "SELECT b FROM BusinessEntityContact b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntityContact implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusinessEntityContactPK businessEntityContactPK;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BusinessEntity businessEntity;
    @JoinColumn(name = "ContactTypeID", referencedColumnName = "ContactTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ContactType contactType;
    @JoinColumn(name = "PersonID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

}
