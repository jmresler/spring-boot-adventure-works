package org.jmresler.hr.aw.svcs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

/**
 * @author jmres
 */
@Data
@Entity
@Table(name = "EmployeeDepartmentHistory", schema = "HumanResources")
public class EmployeeDepartmentHistory implements Serializable {

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
    @JsonBackReference
    private Department department;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "ShiftID", referencedColumnName = "ShiftID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Shift shift;

}
