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
@Table(name = "EmailAddress", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "EmailAddress.selectCount", query = "SELECT COUNT(e) FROM EmailAddress e"),
        @NamedQuery(name = "EmailAddress.findAll", query = "SELECT e FROM EmailAddress e"),
        @NamedQuery(name = "EmailAddress.findByBusinessEntityID", query = "SELECT e FROM EmailAddress e WHERE e.emailAddressPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "EmailAddress.findByEmailAddressID", query = "SELECT e FROM EmailAddress e WHERE e.emailAddressPK.emailAddressID = :emailAddressID"),
        @NamedQuery(name = "EmailAddress.findByEmailAddress", query = "SELECT e FROM EmailAddress e WHERE e.emailAddress = :emailAddress"),
        @NamedQuery(name = "EmailAddress.findByRowguid", query = "SELECT e FROM EmailAddress e WHERE e.rowguid = :rowguid"),
        @NamedQuery(name = "EmailAddress.findByModifiedDate", query = "SELECT e FROM EmailAddress e WHERE e.modifiedDate = :modifiedDate")})
public class EmailAddress implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailAddressPK emailAddressPK;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
}
