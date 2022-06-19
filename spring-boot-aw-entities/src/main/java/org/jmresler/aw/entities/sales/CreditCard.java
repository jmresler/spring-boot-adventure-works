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
@Table(name = "CreditCard", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "CreditCard.selectCount", query = "SELECT COUNT(c) FROM CreditCard c"),
        @NamedQuery(name = "CreditCard.findAll", query = "SELECT c FROM CreditCard c"),
        @NamedQuery(name = "CreditCard.findByCreditCardID", query = "SELECT c FROM CreditCard c WHERE c.creditCardID = :creditCardID"),
        @NamedQuery(name = "CreditCard.findByCardType", query = "SELECT c FROM CreditCard c WHERE c.cardType = :cardType"),
        @NamedQuery(name = "CreditCard.findByCardNumber", query = "SELECT c FROM CreditCard c WHERE c.cardNumber = :cardNumber"),
        @NamedQuery(name = "CreditCard.findByExpMonth", query = "SELECT c FROM CreditCard c WHERE c.expMonth = :expMonth"),
        @NamedQuery(name = "CreditCard.findByExpYear", query = "SELECT c FROM CreditCard c WHERE c.expYear = :expYear"),
        @NamedQuery(name = "CreditCard.findByModifiedDate", query = "SELECT c FROM CreditCard c WHERE c.modifiedDate = :modifiedDate")})
public class CreditCard implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CreditCardID")
    private Integer creditCardID;
    @Column(name = "CardType")
    private String cardType;
    @Column(name = "CardNumber")
    private String cardNumber;
    @Column(name = "ExpMonth")
    private short expMonth;
    @Column(name = "ExpYear")
    private short expYear;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCard")
    private Collection<PersonCreditCard> personCreditCardCollection;
    @OneToMany(mappedBy = "creditCardID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;
}
