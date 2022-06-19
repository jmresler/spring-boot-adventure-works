/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.hr;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@Entity
@Table(name = "EmployeePayHistory", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
        @NamedQuery(name = "EmployeePayHistory.selectCount", query = "SELECT COUNT(e) FROM EmployeePayHistory e"),
        @NamedQuery(name = "EmployeePayHistory.findAll", query = "SELECT e FROM EmployeePayHistory e"),
        @NamedQuery(name = "EmployeePayHistory.findByBusinessEntityID", query = "SELECT e FROM EmployeePayHistory e WHERE e.employeePayHistoryPK.businessEntityID = :businessEntityID"),
        @NamedQuery(name = "EmployeePayHistory.findByRateChangeDate", query = "SELECT e FROM EmployeePayHistory e WHERE e.employeePayHistoryPK.rateChangeDate = :rateChangeDate"),
        @NamedQuery(name = "EmployeePayHistory.findByRate", query = "SELECT e FROM EmployeePayHistory e WHERE e.rate = :rate"),
        @NamedQuery(name = "EmployeePayHistory.findByPayFrequency", query = "SELECT e FROM EmployeePayHistory e WHERE e.payFrequency = :payFrequency"),
        @NamedQuery(name = "EmployeePayHistory.findByModifiedDate", query = "SELECT e FROM EmployeePayHistory e WHERE e.modifiedDate = :modifiedDate")})
public class EmployeePayHistory implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeePayHistoryPK employeePayHistoryPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rate", nullable = false, precision = 19, scale = 4)
    private BigDecimal rate;
    @Column(name = "PayFrequency", nullable = false)
    private short payFrequency;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
}
