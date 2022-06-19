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
@Table(name = "ProductInventory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductInventory.selectCount", query = "SELECT COUNT(p) FROM ProductInventory p"),
        @NamedQuery(name = "ProductInventory.findAll", query = "SELECT p FROM ProductInventory p"),
        @NamedQuery(name = "ProductInventory.findByProductID", query = "SELECT p FROM ProductInventory p WHERE p.productInventoryPK.productID = :productID"),
        @NamedQuery(name = "ProductInventory.findByLocationID", query = "SELECT p FROM ProductInventory p WHERE p.productInventoryPK.locationID = :locationID"),
        @NamedQuery(name = "ProductInventory.findByShelf", query = "SELECT p FROM ProductInventory p WHERE p.shelf = :shelf"),
        @NamedQuery(name = "ProductInventory.findByBin", query = "SELECT p FROM ProductInventory p WHERE p.bin = :bin"),
        @NamedQuery(name = "ProductInventory.findByQuantity", query = "SELECT p FROM ProductInventory p WHERE p.quantity = :quantity"),
        @NamedQuery(name = "ProductInventory.findByRowguid", query = "SELECT p FROM ProductInventory p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "ProductInventory.findByModifiedDate", query = "SELECT p FROM ProductInventory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductInventory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductInventoryPK productInventoryPK;
    @Column(name = "Shelf", nullable = false, length = 10)
    private String shelf;
    @Column(name = "Bin", nullable = false)
    private short bin;
    @Column(name = "Quantity", nullable = false)
    private short quantity;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

}
