/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.hr;

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
@Table(name = "vEmployeeDepartment", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "VEmployeeDepartment.selectCount", query = "SELECT COUNT(v) FROM VEmployeeDepartment v"),
        @NamedQuery(name = "VEmployeeDepartment.findAll", query = "SELECT v FROM VEmployeeDepartment v"),
        @NamedQuery(name = "VEmployeeDepartment.findByBusinessEntityID", query = "SELECT v FROM VEmployeeDepartment v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VEmployeeDepartment.findByTitle", query = "SELECT v FROM VEmployeeDepartment v WHERE v.title = :title"),
        @NamedQuery(name = "VEmployeeDepartment.findByFirstName", query = "SELECT v FROM VEmployeeDepartment v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VEmployeeDepartment.findByMiddleName", query = "SELECT v FROM VEmployeeDepartment v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VEmployeeDepartment.findByLastName", query = "SELECT v FROM VEmployeeDepartment v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VEmployeeDepartment.findBySuffix", query = "SELECT v FROM VEmployeeDepartment v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VEmployeeDepartment.findByJobTitle", query = "SELECT v FROM VEmployeeDepartment v WHERE v.jobTitle = :jobTitle"),
        @NamedQuery(name = "VEmployeeDepartment.findByDepartment", query = "SELECT v FROM VEmployeeDepartment v WHERE v.department = :department"),
        @NamedQuery(name = "VEmployeeDepartment.findByGroupName", query = "SELECT v FROM VEmployeeDepartment v WHERE v.groupName = :groupName"),
        @NamedQuery(name = "VEmployeeDepartment.findByStartDate", query = "SELECT v FROM VEmployeeDepartment v WHERE v.startDate = :startDate")})
public class VEmployeeDepartment implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "Title", length = 8)
    private String title;
    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "MiddleName", length = 50)
    private String middleName;
    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "Suffix", length = 10)
    private String suffix;
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
    @Column(name = "Department", nullable = false, length = 50)
    private String department;
    @Column(name = "GroupName", nullable = false, length = 50)
    private String groupName;
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

}
