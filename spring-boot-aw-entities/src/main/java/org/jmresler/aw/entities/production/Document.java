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
@Table(name = "Document", catalog = "AdventureWorks2017", schema = "Production", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DocumentLevel", "DocumentNode"}),
        @UniqueConstraint(columnNames = {"rowguid"})})
@NamedQueries({
        @NamedQuery(name = "Document.selectCount", query = "SELECT COUNT(d) FROM Document d"),
        @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
        @NamedQuery(name = "Document.findByDocumentLevel", query = "SELECT d FROM Document d WHERE d.documentLevel = :documentLevel"),
        @NamedQuery(name = "Document.findByTitle", query = "SELECT d FROM Document d WHERE d.title = :title"),
        @NamedQuery(name = "Document.findByOwner", query = "SELECT d FROM Document d WHERE d.owner = :owner"),
        @NamedQuery(name = "Document.findByFolderFlag", query = "SELECT d FROM Document d WHERE d.folderFlag = :folderFlag"),
        @NamedQuery(name = "Document.findByFileName", query = "SELECT d FROM Document d WHERE d.fileName = :fileName"),
        @NamedQuery(name = "Document.findByFileExtension", query = "SELECT d FROM Document d WHERE d.fileExtension = :fileExtension"),
        @NamedQuery(name = "Document.findByRevision", query = "SELECT d FROM Document d WHERE d.revision = :revision"),
        @NamedQuery(name = "Document.findByChangeNumber", query = "SELECT d FROM Document d WHERE d.changeNumber = :changeNumber"),
        @NamedQuery(name = "Document.findByStatus", query = "SELECT d FROM Document d WHERE d.status = :status"),
        @NamedQuery(name = "Document.findByDocumentSummary", query = "SELECT d FROM Document d WHERE d.documentSummary = :documentSummary"),
        @NamedQuery(name = "Document.findByRowguid", query = "SELECT d FROM Document d WHERE d.rowguid = :rowguid"),
        @NamedQuery(name = "Document.findByModifiedDate", query = "SELECT d FROM Document d WHERE d.modifiedDate = :modifiedDate")})
public class Document implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Lob
    @Column(name = "DocumentNode", nullable = false)
    private byte[] documentNode;
    @Column(name = "DocumentLevel")
    private Short documentLevel;
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Column(name = "Owner", nullable = false)
    private int owner;
    @Column(name = "FolderFlag", nullable = false)
    private boolean folderFlag;
    @Column(name = "FileName", nullable = false, length = 400)
    private String fileName;
    @Column(name = "FileExtension", nullable = false, length = 8)
    private String fileExtension;
    @Column(name = "Revision", nullable = false, length = 5)
    private String revision;
    @Column(name = "ChangeNumber", nullable = false)
    private int changeNumber;
    @Column(name = "Status", nullable = false)
    private short status;
    @Column(name = "DocumentSummary", length = 2147483647)
    private String documentSummary;
    @Lob
    @Column(name = "Document")
    private byte[] document;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<ProductDocument> productDocumentCollection;

}
