/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vProductAndDescription", catalog = "AdventureWorks2017", schema = "Production")
public class VProductAndDescription implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "ProductModel", nullable = false, length = 50)
    private String productModel;
    @Column(name = "CultureID", nullable = false, length = 6)
    private String cultureID;
    @Column(name = "Description", nullable = false, length = 400)
    private String description;

}
