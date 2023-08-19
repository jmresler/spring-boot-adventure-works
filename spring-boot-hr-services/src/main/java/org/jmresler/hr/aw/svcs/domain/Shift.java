package org.jmresler.hr.aw.svcs.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author jmres
 */
@Data
@Entity
@Table(name = "Shift", schema = "HumanResources")
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShiftID", nullable = false)
    private Short shiftID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "StartTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "EndTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shift", fetch = FetchType.EAGER)
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

}
