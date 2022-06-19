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
@Table(name = "PersonPhone", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "PersonPhone.selectCount", query = "SELECT COUNT(p) FROM PersonPhone p"),
        @NamedQuery(name = "PersonPhone.findAll", query = "SELECT p FROM PersonPhone p"),
        @NamedQuery(name = "PersonPhone.findByBusinessEntityID", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "PersonPhone.findByPhoneNumber", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "PersonPhone.findByPhoneNumberTypeID", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.phoneNumberTypeID = :phoneNumberTypeID"),
        @NamedQuery(name = "PersonPhone.findByModifiedDate", query = "SELECT p FROM PersonPhone p WHERE p.modifiedDate = :modifiedDate")})
public class PersonPhone implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonPhonePK personPhonePK;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "PhoneNumberTypeID", referencedColumnName = "PhoneNumberTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PhoneNumberType phoneNumberType;

}
