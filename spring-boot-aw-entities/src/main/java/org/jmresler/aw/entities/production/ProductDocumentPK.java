/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@Embeddable
public class ProductDocumentPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Lob
    @Column(name = "DocumentNode", nullable = false)
    private byte[] documentNode;

}
