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
@Table(name = "Illustration", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
        @NamedQuery(name = "Illustration.selectCount", query = "SELECT COUNT(i) FROM Illustration i"),
        @NamedQuery(name = "Illustration.findAll", query = "SELECT i FROM Illustration i"),
        @NamedQuery(name = "Illustration.findByIllustrationID", query = "SELECT i FROM Illustration i WHERE i.illustrationID = :illustrationID"),
        @NamedQuery(name = "Illustration.findByDiagram", query = "SELECT i FROM Illustration i WHERE i.diagram = :diagram"),
        @NamedQuery(name = "Illustration.findByModifiedDate", query = "SELECT i FROM Illustration i WHERE i.modifiedDate = :modifiedDate")})
public class Illustration implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IllustrationID", nullable = false)
    private Integer illustrationID;
    @Column(name = "Diagram", length = 2147483647)
    private String diagram;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "illustration")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;


}
