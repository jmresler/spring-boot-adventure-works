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
@Table(name = "vProductModelCatalogDescription", catalog = "AdventureWorks2017", schema = "Production")
public class VProductModelCatalogDescription implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ProductModelID", nullable = false)
    private int productModelID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Summary", length = 2147483647)
    private String summary;
    @Column(name = "Manufacturer", length = 2147483647)
    private String manufacturer;
    @Column(name = "Copyright", length = 30)
    private String copyright;
    @Column(name = "ProductURL", length = 256)
    private String productURL;
    @Column(name = "WarrantyPeriod", length = 256)
    private String warrantyPeriod;
    @Column(name = "WarrantyDescription", length = 256)
    private String warrantyDescription;
    @Column(name = "NoOfYears", length = 256)
    private String noOfYears;
    @Column(name = "MaintenanceDescription", length = 256)
    private String maintenanceDescription;
    @Column(name = "Wheel", length = 256)
    private String wheel;
    @Column(name = "Saddle", length = 256)
    private String saddle;
    @Column(name = "Pedal", length = 256)
    private String pedal;
    @Column(name = "BikeFrame", length = 2147483647)
    private String bikeFrame;
    @Column(name = "Crankset", length = 256)
    private String crankset;
    @Column(name = "PictureAngle", length = 256)
    private String pictureAngle;
    @Column(name = "PictureSize", length = 256)
    private String pictureSize;
    @Column(name = "ProductPhotoID", length = 256)
    private String productPhotoID;
    @Column(name = "Material", length = 256)
    private String material;
    @Column(name = "Color", length = 256)
    private String color;
    @Column(name = "ProductLine", length = 256)
    private String productLine;
    @Column(name = "Style", length = 256)
    private String style;
    @Column(name = "RiderExperience", length = 1024)
    private String riderExperience;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
