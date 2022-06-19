/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.purchasing;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@Embeddable
public class PurchaseOrderDetailPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "PurchaseOrderID")
    private int purchaseOrderID;
    @Column(name = "PurchaseOrderDetailID")
    private int purchaseOrderDetailID;

}
