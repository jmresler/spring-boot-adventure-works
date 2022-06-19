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
@Table(name = "Currency", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "Currency.selectCount", query = "SELECT COUNT(c) FROM Currency c"),
        @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
        @NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode"),
        @NamedQuery(name = "Currency.findByName", query = "SELECT c FROM Currency c WHERE c.name = :name"),
        @NamedQuery(name = "Currency.findByModifiedDate", query = "SELECT c FROM Currency c WHERE c.modifiedDate = :modifiedDate")})
public class Currency implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CurrencyCode")
    private String currencyCode;
    @Column(name = "Name")
    private String name;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromCurrencyCode")
    private Collection<CurrencyRate> currencyRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toCurrencyCode")
    private Collection<CurrencyRate> currencyRateCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency")
    private Collection<CountryRegionCurrency> countryRegionCurrencyCollection;

}
