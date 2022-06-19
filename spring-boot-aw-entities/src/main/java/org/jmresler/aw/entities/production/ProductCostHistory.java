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
@Table(name = "ProductCostHistory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductCostHistory.selectCount", query = "SELECT COUNT(p) FROM ProductCostHistory p"),
        @NamedQuery(name = "ProductCostHistory.findAll", query = "SELECT p FROM ProductCostHistory p"),
        @NamedQuery(name = "ProductCostHistory.findByProductID", query = "SELECT p FROM ProductCostHistory p WHERE p.productCostHistoryPK.productID = :productID"),
        @NamedQuery(name = "ProductCostHistory.findByStartDate", query = "SELECT p FROM ProductCostHistory p WHERE p.productCostHistoryPK.startDate = :startDate"),
        @NamedQuery(name = "ProductCostHistory.findByEndDate", query = "SELECT p FROM ProductCostHistory p WHERE p.endDate = :endDate"),
        @NamedQuery(name = "ProductCostHistory.findByStandardCost", query = "SELECT p FROM ProductCostHistory p WHERE p.standardCost = :standardCost"),
        @NamedQuery(name = "ProductCostHistory.findByModifiedDate", query = "SELECT p FROM ProductCostHistory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductCostHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductCostHistoryPK productCostHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "StandardCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal standardCost;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

}
