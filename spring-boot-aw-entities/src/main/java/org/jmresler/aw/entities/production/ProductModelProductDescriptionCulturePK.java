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
public class ProductModelProductDescriptionCulturePK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ProductModelID", nullable = false)
    private int productModelID;
    @Column(name = "ProductDescriptionID", nullable = false)
    private int productDescriptionID;
    @Column(name = "CultureID", nullable = false, length = 6)
    private String cultureID;

}
