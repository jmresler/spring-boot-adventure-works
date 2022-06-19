/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@Embeddable
public class CountryRegionCurrencyPK implements Serializable {

    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Column(name = "CurrencyCode")
    private String currencyCode;
}
