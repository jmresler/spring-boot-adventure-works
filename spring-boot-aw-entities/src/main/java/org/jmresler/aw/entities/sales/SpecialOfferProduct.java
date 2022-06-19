/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.sales;

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
@Table(name = "SpecialOfferProduct", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SpecialOfferProduct.selectCount", query = "SELECT COUNT(s) FROM SpecialOfferProduct s"),
        @NamedQuery(name = "SpecialOfferProduct.findAll", query = "SELECT s FROM SpecialOfferProduct s"),
        @NamedQuery(name = "SpecialOfferProduct.findBySpecialOfferID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.specialOfferID = :specialOfferID"),
        @NamedQuery(name = "SpecialOfferProduct.findByProductID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.productID = :productID"),
        @NamedQuery(name = "SpecialOfferProduct.findByRowguid", query = "SELECT s FROM SpecialOfferProduct s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SpecialOfferProduct.findByModifiedDate", query = "SELECT s FROM SpecialOfferProduct s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOfferProduct implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecialOfferProductPK specialOfferProductPK;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOfferProduct")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;
    @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SpecialOffer specialOffer;

}
