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
@Table(name = "PhoneNumberType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "PhoneNumberType.selectCount", query = "SELECT COUNT(p) FROM PhoneNumberType p"),
        @NamedQuery(name = "PhoneNumberType.findAll", query = "SELECT p FROM PhoneNumberType p"),
        @NamedQuery(name = "PhoneNumberType.findByPhoneNumberTypeID", query = "SELECT p FROM PhoneNumberType p WHERE p.phoneNumberTypeID = :phoneNumberTypeID"),
        @NamedQuery(name = "PhoneNumberType.findByName", query = "SELECT p FROM PhoneNumberType p WHERE p.name = :name"),
        @NamedQuery(name = "PhoneNumberType.findByModifiedDate", query = "SELECT p FROM PhoneNumberType p WHERE p.modifiedDate = :modifiedDate")})
public class PhoneNumberType implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhoneNumberTypeID")
    private Integer phoneNumberTypeID;
    @Column(name = "Name")
    private String name;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phoneNumberType")
    private Collection<PersonPhone> personPhoneCollection;


}
