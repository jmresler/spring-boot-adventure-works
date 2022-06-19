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
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "Department", catalog = "AdventureWorks2017", schema = "HumanResources", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"})})
@NamedQueries({
        @NamedQuery(name = "Department.selectCount", query = "SELECT COUNT(d) FROM Department d"),
        @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
        @NamedQuery(name = "Department.findByDepartmentID", query = "SELECT d FROM Department d WHERE d.departmentID = :departmentID"),
        @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
        @NamedQuery(name = "Department.findByGroupName", query = "SELECT d FROM Department d WHERE d.groupName = :groupName"),
        @NamedQuery(name = "Department.findByModifiedDate", query = "SELECT d FROM Department d WHERE d.modifiedDate = :modifiedDate")})
public class Department implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID", nullable = false)
    private Short departmentID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "GroupName", nullable = false, length = 50)
    private String groupName;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

}
