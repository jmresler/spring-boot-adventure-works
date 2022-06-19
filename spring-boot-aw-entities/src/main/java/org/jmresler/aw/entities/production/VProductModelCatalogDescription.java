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
@NamedQueries({
        @NamedQuery(name = "VProductModelCatalogDescription.selectCount", query = "SELECT COUNT(v) FROM VProductModelCatalogDescription v"),
        @NamedQuery(name = "VProductModelCatalogDescription.findAll", query = "SELECT v FROM VProductModelCatalogDescription v"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByProductModelID", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productModelID = :productModelID"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByName", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.name = :name"),
        @NamedQuery(name = "VProductModelCatalogDescription.findBySummary", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.summary = :summary"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByManufacturer", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.manufacturer = :manufacturer"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByCopyright", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.copyright = :copyright"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByProductURL", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productURL = :productURL"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByWarrantyPeriod", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.warrantyPeriod = :warrantyPeriod"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByWarrantyDescription", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.warrantyDescription = :warrantyDescription"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByNoOfYears", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.noOfYears = :noOfYears"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByMaintenanceDescription", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.maintenanceDescription = :maintenanceDescription"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByWheel", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.wheel = :wheel"),
        @NamedQuery(name = "VProductModelCatalogDescription.findBySaddle", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.saddle = :saddle"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByPedal", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.pedal = :pedal"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByBikeFrame", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.bikeFrame = :bikeFrame"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByCrankset", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.crankset = :crankset"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByPictureAngle", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.pictureAngle = :pictureAngle"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByPictureSize", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.pictureSize = :pictureSize"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByProductPhotoID", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productPhotoID = :productPhotoID"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByMaterial", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.material = :material"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByColor", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.color = :color"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByProductLine", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productLine = :productLine"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByStyle", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.style = :style"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByRiderExperience", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.riderExperience = :riderExperience"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByRowguid", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.rowguid = :rowguid"),
        @NamedQuery(name = "VProductModelCatalogDescription.findByModifiedDate", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.modifiedDate = :modifiedDate")})
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
