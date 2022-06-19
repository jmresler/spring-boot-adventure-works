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
@Table(name = "ProductProductPhoto", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductProductPhoto.selectCount", query = "SELECT COUNT(p) FROM ProductProductPhoto p"),
        @NamedQuery(name = "ProductProductPhoto.findAll", query = "SELECT p FROM ProductProductPhoto p"),
        @NamedQuery(name = "ProductProductPhoto.findByProductID", query = "SELECT p FROM ProductProductPhoto p WHERE p.productProductPhotoPK.productID = :productID"),
        @NamedQuery(name = "ProductProductPhoto.findByProductPhotoID", query = "SELECT p FROM ProductProductPhoto p WHERE p.productProductPhotoPK.productPhotoID = :productPhotoID"),
        @NamedQuery(name = "ProductProductPhoto.findByPrimary", query = "SELECT p FROM ProductProductPhoto p WHERE p.primary = :primary"),
        @NamedQuery(name = "ProductProductPhoto.findByModifiedDate", query = "SELECT p FROM ProductProductPhoto p WHERE p.modifiedDate = :modifiedDate")})
public class ProductProductPhoto implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductProductPhotoPK productProductPhotoPK;
    @Column(name = "\"Primary\"", nullable = false)
    private boolean primary;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ProductPhotoID", referencedColumnName = "ProductPhotoID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductPhoto productPhoto;

}
