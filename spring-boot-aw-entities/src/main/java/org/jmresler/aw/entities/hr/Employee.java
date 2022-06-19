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
@NamedQueries({
        @NamedQuery(name = "Employee.selectCount", query = "SELECT COUNT(e) FROM Employee e"),
        @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findByBusinessEntityID", query = "SELECT e FROM Employee e WHERE e.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "Employee.findByNationalIDNumber", query = "SELECT e FROM Employee e WHERE e.nationalIDNumber = :nationalIDNumber"),
        @NamedQuery(name = "Employee.findByLoginID", query = "SELECT e FROM Employee e WHERE e.loginID = :loginID"),
        @NamedQuery(name = "Employee.findByOrganizationLevel", query = "SELECT e FROM Employee e WHERE e.organizationLevel = :organizationLevel"),
        @NamedQuery(name = "Employee.findByJobTitle", query = "SELECT e FROM Employee e WHERE e.jobTitle = :jobTitle"),
        @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate"),
        @NamedQuery(name = "Employee.findByMaritalStatus", query = "SELECT e FROM Employee e WHERE e.maritalStatus = :maritalStatus"),
        @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender"),
        @NamedQuery(name = "Employee.findByHireDate", query = "SELECT e FROM Employee e WHERE e.hireDate = :hireDate"),
        @NamedQuery(name = "Employee.findBySalariedFlag", query = "SELECT e FROM Employee e WHERE e.salariedFlag = :salariedFlag"),
        @NamedQuery(name = "Employee.findByVacationHours", query = "SELECT e FROM Employee e WHERE e.vacationHours = :vacationHours"),
        @NamedQuery(name = "Employee.findBySickLeaveHours", query = "SELECT e FROM Employee e WHERE e.sickLeaveHours = :sickLeaveHours"),
        @NamedQuery(name = "Employee.findByCurrentFlag", query = "SELECT e FROM Employee e WHERE e.currentFlag = :currentFlag"),
        @NamedQuery(name = "Employee.findByRowguid", query = "SELECT e FROM Employee e WHERE e.rowguid = :rowguid"),
        @NamedQuery(name = "Employee.findByModifiedDate", query = "SELECT e FROM Employee e WHERE e.modifiedDate = :modifiedDate")})
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
