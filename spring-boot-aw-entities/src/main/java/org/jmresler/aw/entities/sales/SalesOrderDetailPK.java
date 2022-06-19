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
public class SalesOrderDetailPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "SalesOrderID")
    private int salesOrderID;
    @Column(name = "SalesOrderDetailID")
    private int salesOrderDetailID;

}
