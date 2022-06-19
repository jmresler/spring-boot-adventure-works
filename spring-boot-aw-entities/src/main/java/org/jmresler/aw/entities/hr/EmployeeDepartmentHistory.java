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
@Table(name = "EmployeeDepartmentHistory", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "EmployeeDepartmentHistory.selectCount", query = "SELECT COUNT(e) FROM EmployeeDepartmentHistory e"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findAll", query = "SELECT e FROM EmployeeDepartmentHistory e"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findByBusinessEntityID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findByDepartmentID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.departmentID = :departmentID"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findByShiftID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.shiftID = :shiftID"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findByStartDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.startDate = :startDate"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findByEndDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.endDate = :endDate"),
        @NamedQuery(name = "EmployeeDepartmentHistory.findByModifiedDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.modifiedDate = :modifiedDate")})
public class EmployeeDepartmentHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmployeeDepartmentHistoryPK employeeDepartmentHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "ShiftID", referencedColumnName = "ShiftID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Shift shift;

}
