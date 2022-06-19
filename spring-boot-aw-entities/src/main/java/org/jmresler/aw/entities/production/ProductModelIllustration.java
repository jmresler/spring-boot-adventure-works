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
@Table(name = "ProductModelIllustration", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductModelIllustration.selectCount", query = "SELECT COUNT(p) FROM ProductModelIllustration p"),
        @NamedQuery(name = "ProductModelIllustration.findAll", query = "SELECT p FROM ProductModelIllustration p"),
        @NamedQuery(name = "ProductModelIllustration.findByProductModelID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.productModelID = :productModelID"),
        @NamedQuery(name = "ProductModelIllustration.findByIllustrationID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.illustrationID = :illustrationID"),
        @NamedQuery(name = "ProductModelIllustration.findByModifiedDate", query = "SELECT p FROM ProductModelIllustration p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelIllustration implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductModelIllustrationPK productModelIllustrationPK;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "IllustrationID", referencedColumnName = "IllustrationID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Illustration illustration;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;

}
