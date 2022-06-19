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
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "ProductModelProductDescriptionCulture", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductModelProductDescriptionCulture.selectCount", query = "SELECT COUNT(p) FROM ProductModelProductDescriptionCulture p"),
        @NamedQuery(name = "ProductModelProductDescriptionCulture.findAll", query = "SELECT p FROM ProductModelProductDescriptionCulture p"),
        @NamedQuery(name = "ProductModelProductDescriptionCulture.findByProductModelID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.productModelID = :productModelID"),
        @NamedQuery(name = "ProductModelProductDescriptionCulture.findByProductDescriptionID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.productDescriptionID = :productDescriptionID"),
        @NamedQuery(name = "ProductModelProductDescriptionCulture.findByCultureID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.cultureID = :cultureID"),
        @NamedQuery(name = "ProductModelProductDescriptionCulture.findByModifiedDate", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelProductDescriptionCulture implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductModelProductDescriptionCulturePK productModelProductDescriptionCulturePK;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CultureID", referencedColumnName = "CultureID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Culture culture;
    @JoinColumn(name = "ProductDescriptionID", referencedColumnName = "ProductDescriptionID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductDescription productDescription;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;

}
