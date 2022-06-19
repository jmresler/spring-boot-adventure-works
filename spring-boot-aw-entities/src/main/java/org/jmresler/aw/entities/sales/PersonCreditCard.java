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
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "PersonCreditCard", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "PersonCreditCard.selectCount", query = "SELECT COUNT(p) FROM PersonCreditCard p"),
        @NamedQuery(name = "PersonCreditCard.findAll", query = "SELECT p FROM PersonCreditCard p"),
        @NamedQuery(name = "PersonCreditCard.findByBusinessEntityID", query = "SELECT p FROM PersonCreditCard p WHERE p.personCreditCardPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "PersonCreditCard.findByCreditCardID", query = "SELECT p FROM PersonCreditCard p WHERE p.personCreditCardPK.creditCardID = :creditCardID"),
        @NamedQuery(name = "PersonCreditCard.findByModifiedDate", query = "SELECT p FROM PersonCreditCard p WHERE p.modifiedDate = :modifiedDate")})
public class PersonCreditCard implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonCreditCardPK personCreditCardPK;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CreditCard creditCard;

}
