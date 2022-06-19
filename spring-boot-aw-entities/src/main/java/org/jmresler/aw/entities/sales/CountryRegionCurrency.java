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
@Table(name = "CountryRegionCurrency", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "CountryRegionCurrency.selectCount", query = "SELECT COUNT(c) FROM CountryRegionCurrency c"),
        @NamedQuery(name = "CountryRegionCurrency.findAll", query = "SELECT c FROM CountryRegionCurrency c"),
        @NamedQuery(name = "CountryRegionCurrency.findByCountryRegionCode", query = "SELECT c FROM CountryRegionCurrency c WHERE c.countryRegionCurrencyPK.countryRegionCode = :countryRegionCode"),
        @NamedQuery(name = "CountryRegionCurrency.findByCurrencyCode", query = "SELECT c FROM CountryRegionCurrency c WHERE c.countryRegionCurrencyPK.currencyCode = :currencyCode"),
        @NamedQuery(name = "CountryRegionCurrency.findByModifiedDate", query = "SELECT c FROM CountryRegionCurrency c WHERE c.modifiedDate = :modifiedDate")})
public class CountryRegionCurrency implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CountryRegionCurrencyPK countryRegionCurrencyPK;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CurrencyCode", referencedColumnName = "CurrencyCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Currency currency;

}
