/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.production;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "vProductAndDescription", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "VProductAndDescription.selectCount", query = "SELECT COUNT(v) FROM VProductAndDescription v"),
        @NamedQuery(name = "VProductAndDescription.findAll", query = "SELECT v FROM VProductAndDescription v"),
        @NamedQuery(name = "VProductAndDescription.findByProductID", query = "SELECT v FROM VProductAndDescription v WHERE v.productID = :productID"),
        @NamedQuery(name = "VProductAndDescription.findByName", query = "SELECT v FROM VProductAndDescription v WHERE v.name = :name"),
        @NamedQuery(name = "VProductAndDescription.findByProductModel", query = "SELECT v FROM VProductAndDescription v WHERE v.productModel = :productModel"),
        @NamedQuery(name = "VProductAndDescription.findByCultureID", query = "SELECT v FROM VProductAndDescription v WHERE v.cultureID = :cultureID"),
        @NamedQuery(name = "VProductAndDescription.findByDescription", query = "SELECT v FROM VProductAndDescription v WHERE v.description = :description")})
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
