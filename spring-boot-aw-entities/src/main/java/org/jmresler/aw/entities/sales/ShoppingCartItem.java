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
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "ShoppingCartItem", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
        @NamedQuery(name = "ShoppingCartItem.selectCount", query = "SELECT COUNT(s) FROM ShoppingCartItem s"),
        @NamedQuery(name = "ShoppingCartItem.findAll", query = "SELECT s FROM ShoppingCartItem s"),
        @NamedQuery(name = "ShoppingCartItem.findByShoppingCartItemID", query = "SELECT s FROM ShoppingCartItem s WHERE s.shoppingCartItemID = :shoppingCartItemID"),
        @NamedQuery(name = "ShoppingCartItem.findByShoppingCartID", query = "SELECT s FROM ShoppingCartItem s WHERE s.shoppingCartID = :shoppingCartID"),
        @NamedQuery(name = "ShoppingCartItem.findByQuantity", query = "SELECT s FROM ShoppingCartItem s WHERE s.quantity = :quantity"),
        @NamedQuery(name = "ShoppingCartItem.findByProductID", query = "SELECT s FROM ShoppingCartItem s WHERE s.productID = :productID"),
        @NamedQuery(name = "ShoppingCartItem.findByDateCreated", query = "SELECT s FROM ShoppingCartItem s WHERE s.dateCreated = :dateCreated"),
        @NamedQuery(name = "ShoppingCartItem.findByModifiedDate", query = "SELECT s FROM ShoppingCartItem s WHERE s.modifiedDate = :modifiedDate")})
public class ShoppingCartItem implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShoppingCartItemID")
    private Integer shoppingCartItemID;
    @Column(name = "ShoppingCartID")
    private String shoppingCartID;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "ProductID")
    private int productID;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

}
