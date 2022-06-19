/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@Embeddable
public class WorkOrderRoutingPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "WorkOrderID", nullable = false)
    private int workOrderID;
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Column(name = "OperationSequence", nullable = false)
    private short operationSequence;

}
