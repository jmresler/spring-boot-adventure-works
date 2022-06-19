/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.person;

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
@Table(name = "Password", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
        @NamedQuery(name = "Password.selectCount", query = "SELECT COUNT(p) FROM Password p"),
        @NamedQuery(name = "Password.findAll", query = "SELECT p FROM Password p"),
        @NamedQuery(name = "Password.findByBusinessEntityID", query = "SELECT p FROM Password p WHERE p.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "Password.findByPasswordHash", query = "SELECT p FROM Password p WHERE p.passwordHash = :passwordHash"),
        @NamedQuery(name = "Password.findByPasswordSalt", query = "SELECT p FROM Password p WHERE p.passwordSalt = :passwordSalt"),
        @NamedQuery(name = "Password.findByRowguid", query = "SELECT p FROM Password p WHERE p.rowguid = :rowguid"),
        @NamedQuery(name = "Password.findByModifiedDate", query = "SELECT p FROM Password p WHERE p.modifiedDate = :modifiedDate")})
public class Password implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "PasswordHash")
    private String passwordHash;
    @Column(name = "PasswordSalt")
    private String passwordSalt;
    @Column(name = "rowguid")
    private String rowguid;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;


}
