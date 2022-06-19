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
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "SpecialOffer", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "SpecialOffer.selectCount", query = "SELECT COUNT(s) FROM SpecialOffer s"),
        @NamedQuery(name = "SpecialOffer.findAll", query = "SELECT s FROM SpecialOffer s"),
        @NamedQuery(name = "SpecialOffer.findBySpecialOfferID", query = "SELECT s FROM SpecialOffer s WHERE s.specialOfferID = :specialOfferID"),
        @NamedQuery(name = "SpecialOffer.findByDescription", query = "SELECT s FROM SpecialOffer s WHERE s.description = :description"),
        @NamedQuery(name = "SpecialOffer.findByDiscountPct", query = "SELECT s FROM SpecialOffer s WHERE s.discountPct = :discountPct"),
        @NamedQuery(name = "SpecialOffer.findByType", query = "SELECT s FROM SpecialOffer s WHERE s.type = :type"),
        @NamedQuery(name = "SpecialOffer.findByCategory", query = "SELECT s FROM SpecialOffer s WHERE s.category = :category"),
        @NamedQuery(name = "SpecialOffer.findByStartDate", query = "SELECT s FROM SpecialOffer s WHERE s.startDate = :startDate"),
        @NamedQuery(name = "SpecialOffer.findByEndDate", query = "SELECT s FROM SpecialOffer s WHERE s.endDate = :endDate"),
        @NamedQuery(name = "SpecialOffer.findByMinQty", query = "SELECT s FROM SpecialOffer s WHERE s.minQty = :minQty"),
        @NamedQuery(name = "SpecialOffer.findByMaxQty", query = "SELECT s FROM SpecialOffer s WHERE s.maxQty = :maxQty"),
        @NamedQuery(name = "SpecialOffer.findByRowguid", query = "SELECT s FROM SpecialOffer s WHERE s.rowguid = :rowguid"),
        @NamedQuery(name = "SpecialOffer.findByModifiedDate", query = "SELECT s FROM SpecialOffer s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOffer implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpecialOfferID")
    private Integer specialOfferID;
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DiscountPct")
    private BigDecimal discountPct;
    @Column(name = "Type")
    private String type;
    @Column(name = "Category")
    private String category;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "MinQty")
    private int minQty;
    @Column(name = "MaxQty")
    private Integer maxQty;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOffer")
    private Collection<SpecialOfferProduct> specialOfferProductCollection;
}
