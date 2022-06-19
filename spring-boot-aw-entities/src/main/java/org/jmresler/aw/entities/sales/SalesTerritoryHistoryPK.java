/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@Embeddable
public class SalesTerritoryHistoryPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "TerritoryID")
    private int territoryID;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
}
