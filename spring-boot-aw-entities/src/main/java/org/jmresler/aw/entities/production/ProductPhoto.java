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
@Table(name = "ProductPhoto", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "ProductPhoto.selectCount", query = "SELECT COUNT(p) FROM ProductPhoto p"),
        @NamedQuery(name = "ProductPhoto.findAll", query = "SELECT p FROM ProductPhoto p"),
        @NamedQuery(name = "ProductPhoto.findByProductPhotoID", query = "SELECT p FROM ProductPhoto p WHERE p.productPhotoID = :productPhotoID"),
        @NamedQuery(name = "ProductPhoto.findByThumbnailPhotoFileName", query = "SELECT p FROM ProductPhoto p WHERE p.thumbnailPhotoFileName = :thumbnailPhotoFileName"),
        @NamedQuery(name = "ProductPhoto.findByLargePhotoFileName", query = "SELECT p FROM ProductPhoto p WHERE p.largePhotoFileName = :largePhotoFileName"),
        @NamedQuery(name = "ProductPhoto.findByModifiedDate", query = "SELECT p FROM ProductPhoto p WHERE p.modifiedDate = :modifiedDate")})
public class ProductPhoto implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductPhotoID", nullable = false)
    private Integer productPhotoID;
    @Lob
    @Column(name = "ThumbNailPhoto")
    private byte[] thumbNailPhoto;
    @Column(name = "ThumbnailPhotoFileName", length = 50)
    private String thumbnailPhotoFileName;
    @Lob
    @Column(name = "LargePhoto")
    private byte[] largePhoto;
    @Column(name = "LargePhotoFileName", length = 50)
    private String largePhotoFileName;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productPhoto")
    private Collection<ProductProductPhoto> productProductPhotoCollection;
}
