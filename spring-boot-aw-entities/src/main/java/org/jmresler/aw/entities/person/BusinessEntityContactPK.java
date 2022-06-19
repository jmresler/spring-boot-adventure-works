/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.person;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@Embeddable
public class BusinessEntityContactPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "PersonID")
    private int personID;
    @Column(name = "ContactTypeID")
    private int contactTypeID;

}
