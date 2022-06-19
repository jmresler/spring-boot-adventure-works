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
@Table(name = "ProductDescription", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"rowguid"})})
@NamedQueries({
        @NamedQuery(name = "ProductDescription.selectCount", query = "SELECT COUNT(p) FROM ProductDescription p"),
        @NamedQuery(name = "ProductDescription.findAll", query = "SELECT p FROM ProductDescription p"),
        @NamedQuery(name = "ProductDescription.findByProductDescriptionID", query = "SELECT p FROM ProductDescription p WHERE p.productDescriptionID = :productDescriptionID"),
        @NamedQuery(name = "ProductDescription.findByDescription", query = "SELECT p FROM ProductDescription p WHERE p.description = :description"),
        @NamedQuery(name = "ProductDescription.findByRowguid", query = "SELECT p FROM ProductDescription p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "ProductDescription.findByModifiedDate", query = "SELECT p FROM ProductDescription p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDescription implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductDescriptionID", nullable = false)
    private Integer productDescriptionID;
    @Column(name = "Description", nullable = false, length = 400)
    private String description;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDescription")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

}
