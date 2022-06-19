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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "ProductModel", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"}),
        @UniqueConstraint(columnNames = {"rowguid"})})
@NamedQueries({
        @NamedQuery(name = "ProductModel.selectCount", query = "SELECT COUNT(p) FROM ProductModel p"),
        @NamedQuery(name = "ProductModel.findAll", query = "SELECT p FROM ProductModel p"),
        @NamedQuery(name = "ProductModel.findByProductModelID", query = "SELECT p FROM ProductModel p WHERE p.productModelID = :productModelID"),
        @NamedQuery(name = "ProductModel.findByName", query = "SELECT p FROM ProductModel p WHERE p.name = :name"),
        @NamedQuery(name = "ProductModel.findByCatalogDescription", query = "SELECT p FROM ProductModel p WHERE p.catalogDescription = :catalogDescription"),
        @NamedQuery(name = "ProductModel.findByInstructions", query = "SELECT p FROM ProductModel p WHERE p.instructions = :instructions"),
        @NamedQuery(name = "ProductModel.findByRowguid", query = "SELECT p FROM ProductModel p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "ProductModel.findByModifiedDate", query = "SELECT p FROM ProductModel p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModel implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductModelID", nullable = false)
    private Integer productModelID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "CatalogDescription", length = 2147483647)
    private String catalogDescription;
    @Column(name = "Instructions", length = 2147483647)
    private String instructions;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;
    @OneToMany(mappedBy = "productModelID")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;
}
