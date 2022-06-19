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
@Table(name = "ProductDocument", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductDocument.selectCount", query = "SELECT COUNT(p) FROM ProductDocument p"),
        @NamedQuery(name = "ProductDocument.findAll", query = "SELECT p FROM ProductDocument p"),
        @NamedQuery(name = "ProductDocument.findByProductID", query = "SELECT p FROM ProductDocument p WHERE p.productDocumentPK.productID = :productID"),
        @NamedQuery(name = "ProductDocument.findByModifiedDate", query = "SELECT p FROM ProductDocument p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDocument implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductDocumentPK productDocumentPK;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "DocumentNode", referencedColumnName = "DocumentNode", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

}
