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
@Table(name = "ProductReview", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductReview.selectCount", query = "SELECT COUNT(p) FROM ProductReview p"),
        @NamedQuery(name = "ProductReview.findAll", query = "SELECT p FROM ProductReview p"),
        @NamedQuery(name = "ProductReview.findByProductReviewID", query = "SELECT p FROM ProductReview p WHERE p.productReviewID = :productReviewID"),
        @NamedQuery(name = "ProductReview.findByReviewerName", query = "SELECT p FROM ProductReview p WHERE p.reviewerName = :reviewerName"),
        @NamedQuery(name = "ProductReview.findByReviewDate", query = "SELECT p FROM ProductReview p WHERE p.reviewDate = :reviewDate"),
        @NamedQuery(name = "ProductReview.findByEmailAddress", query = "SELECT p FROM ProductReview p WHERE p.emailAddress = :emailAddress"),
        @NamedQuery(name = "ProductReview.findByRating", query = "SELECT p FROM ProductReview p WHERE p.rating = :rating"),
        @NamedQuery(name = "ProductReview.findByComments", query = "SELECT p FROM ProductReview p WHERE p.comments = :comments"),
        @NamedQuery(name = "ProductReview.findByModifiedDate", query = "SELECT p FROM ProductReview p WHERE p.modifiedDate = :modifiedDate")})
public class ProductReview implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductReviewID", nullable = false)
    private Integer productReviewID;
    @Column(name = "ReviewerName", nullable = false, length = 50)
    private String reviewerName;
    @Column(name = "ReviewDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
    @Column(name = "EmailAddress", nullable = false, length = 50)
    private String emailAddress;
    @Column(name = "Rating", nullable = false)
    private int rating;
    @Column(name = "Comments", length = 3850)
    private String comments;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product productID;

}
