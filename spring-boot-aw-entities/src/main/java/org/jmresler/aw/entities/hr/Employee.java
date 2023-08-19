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
@Table(name = "Employee", catalog = "AdventureWorks2017", schema = "HumanResources", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"LoginID"}),
        @UniqueConstraint(columnNames = {"NationalIDNumber"}),
        @UniqueConstraint(columnNames = {"rowguid"})})
public class Employee implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BusinessEntityID", nullable = false)
    private Integer businessEntityID;
    @Column(name = "NationalIDNumber", nullable = false, length = 15)
    private String nationalIDNumber;
    @Column(name = "LoginID", nullable = false, length = 256)
    private String loginID;
    @Lob
    @Column(name = "OrganizationNode")
    private byte[] organizationNode;
    @Column(name = "OrganizationLevel")
    private Short organizationLevel;
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
    @Column(name = "BirthDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "MaritalStatus", nullable = false, length = 1)
    private String maritalStatus;
    @Column(name = "Gender", nullable = false, length = 1)
    private String gender;
    @Column(name = "HireDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(name = "SalariedFlag", nullable = false)
    private boolean salariedFlag;
    @Column(name = "VacationHours", nullable = false)
    private short vacationHours;
    @Column(name = "SickLeaveHours", nullable = false)
    private short sickLeaveHours;
    @Column(name = "CurrentFlag", nullable = false)
    private boolean currentFlag;
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<EmployeePayHistory> employeePayHistoryCollection;
    @OneToMany(mappedBy = "businessEntityID", fetch = FetchType.LAZY)
    private Collection<JobCandidate> jobCandidateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

}
