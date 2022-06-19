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
@Table(name = "vEmployeeDepartmentHistory", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "VEmployeeDepartmentHistory.selectCount", query = "SELECT COUNT(v) FROM VEmployeeDepartmentHistory v"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findAll", query = "SELECT v FROM VEmployeeDepartmentHistory v"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByBusinessEntityID", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByTitle", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.title = :title"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByFirstName", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByMiddleName", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.middleName = :middleName"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByLastName", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findBySuffix", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.suffix = :suffix"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByShift", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.shift = :shift"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByDepartment", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.department = :department"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByGroupName", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.groupName = :groupName"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByStartDate", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.startDate = :startDate"),
        @NamedQuery(name = "VEmployeeDepartmentHistory.findByEndDate", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.endDate = :endDate")})
public class VEmployeeDepartmentHistory implements Serializable, JsonSerializable {

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
    @Column(name = "Shift", nullable = false, length = 50)
    private String shift;
    @Column(name = "Department", nullable = false, length = 50)
    private String department;
    @Column(name = "GroupName", nullable = false, length = 50)
    private String groupName;
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
