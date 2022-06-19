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
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "ProductListPriceHistory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductListPriceHistory.selectCount", query = "SELECT COUNT(p) FROM ProductListPriceHistory p"),
        @NamedQuery(name = "ProductListPriceHistory.findAll", query = "SELECT p FROM ProductListPriceHistory p"),
        @NamedQuery(name = "ProductListPriceHistory.findByProductID", query = "SELECT p FROM ProductListPriceHistory p WHERE p.productListPriceHistoryPK.productID = :productID"),
        @NamedQuery(name = "ProductListPriceHistory.findByStartDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.productListPriceHistoryPK.startDate = :startDate"),
        @NamedQuery(name = "ProductListPriceHistory.findByEndDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.endDate = :endDate"),
        @NamedQuery(name = "ProductListPriceHistory.findByListPrice", query = "SELECT p FROM ProductListPriceHistory p WHERE p.listPrice = :listPrice"),
        @NamedQuery(name = "ProductListPriceHistory.findByModifiedDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductListPriceHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductListPriceHistoryPK productListPriceHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ListPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal listPrice;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

}
