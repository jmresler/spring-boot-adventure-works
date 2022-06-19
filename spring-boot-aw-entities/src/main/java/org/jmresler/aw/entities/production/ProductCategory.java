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
@Table(name = "ProductCategory", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"}),
        @UniqueConstraint(columnNames = {"rowguid"})})
@NamedQueries({
        @NamedQuery(name = "ProductCategory.selectCount", query = "SELECT COUNT(p) FROM ProductCategory p"),
        @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p"),
        @NamedQuery(name = "ProductCategory.findByProductCategoryID", query = "SELECT p FROM ProductCategory p WHERE p.productCategoryID = :productCategoryID"),
        @NamedQuery(name = "ProductCategory.findByName", query = "SELECT p FROM ProductCategory p WHERE p.name = :name"),
        @NamedQuery(name = "ProductCategory.findByRowguid", query = "SELECT p FROM ProductCategory p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "ProductCategory.findByModifiedDate", query = "SELECT p FROM ProductCategory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductCategory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductCategoryID", nullable = false)
    private Integer productCategoryID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategoryID")
    private Collection<ProductSubcategory> productSubcategoryCollection;


}
