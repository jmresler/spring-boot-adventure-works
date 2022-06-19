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
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "CurrencyRate", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "CurrencyRate.selectCount", query = "SELECT COUNT(c) FROM CurrencyRate c"),
        @NamedQuery(name = "CurrencyRate.findAll", query = "SELECT c FROM CurrencyRate c"),
        @NamedQuery(name = "CurrencyRate.findByCurrencyRateID", query = "SELECT c FROM CurrencyRate c WHERE c.currencyRateID = :currencyRateID"),
        @NamedQuery(name = "CurrencyRate.findByCurrencyRateDate", query = "SELECT c FROM CurrencyRate c WHERE c.currencyRateDate = :currencyRateDate"),
        @NamedQuery(name = "CurrencyRate.findByAverageRate", query = "SELECT c FROM CurrencyRate c WHERE c.averageRate = :averageRate"),
        @NamedQuery(name = "CurrencyRate.findByEndOfDayRate", query = "SELECT c FROM CurrencyRate c WHERE c.endOfDayRate = :endOfDayRate"),
        @NamedQuery(name = "CurrencyRate.findByModifiedDate", query = "SELECT c FROM CurrencyRate c WHERE c.modifiedDate = :modifiedDate")})
public class CurrencyRate implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CurrencyRateID")
    private Integer currencyRateID;
    @Column(name = "CurrencyRateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currencyRateDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AverageRate")
    private BigDecimal averageRate;
    @Column(name = "EndOfDayRate")
    private BigDecimal endOfDayRate;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "FromCurrencyCode", referencedColumnName = "CurrencyCode")
    @ManyToOne(optional = false)
    private Currency fromCurrencyCode;
    @JoinColumn(name = "ToCurrencyCode", referencedColumnName = "CurrencyCode")
    @ManyToOne(optional = false)
    private Currency toCurrencyCode;
    @OneToMany(mappedBy = "currencyRateID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;
}
