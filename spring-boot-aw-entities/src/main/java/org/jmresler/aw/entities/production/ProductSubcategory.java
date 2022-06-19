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
@Table(name = "ProductSubcategory", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"}),
        @UniqueConstraint(columnNames = {"rowguid"})})
@NamedQueries({
        @NamedQuery(name = "ProductSubcategory.selectCount", query = "SELECT COUNT(p) FROM ProductSubcategory p"),
        @NamedQuery(name = "ProductSubcategory.findAll", query = "SELECT p FROM ProductSubcategory p"),
        @NamedQuery(name = "ProductSubcategory.findByProductSubcategoryID", query = "SELECT p FROM ProductSubcategory p WHERE p.productSubcategoryID = :productSubcategoryID"),
        @NamedQuery(name = "ProductSubcategory.findByName", query = "SELECT p FROM ProductSubcategory p WHERE p.name = :name"),
        @NamedQuery(name = "ProductSubcategory.findByRowguid", query = "SELECT p FROM ProductSubcategory p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "ProductSubcategory.findByModifiedDate", query = "SELECT p FROM ProductSubcategory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductSubcategory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductSubcategoryID", nullable = false)
    private Integer productSubcategoryID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "productSubcategoryID")
    private Collection<Product> productCollection;
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID", nullable = false)
    @ManyToOne(optional = false)
    private ProductCategory productCategoryID;
}
