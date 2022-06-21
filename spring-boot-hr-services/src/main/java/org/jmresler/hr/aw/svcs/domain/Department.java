/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.hr.aw.svcs.domain;

import lombok.Data;
import org.jmresler.hr.aw.svcs.util.JsonSerializable;

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
@Table(name = "Department",  schema = "HumanResources")
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
