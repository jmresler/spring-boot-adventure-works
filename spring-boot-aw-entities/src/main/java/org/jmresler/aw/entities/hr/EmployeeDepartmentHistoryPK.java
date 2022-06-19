/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.hr;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@Embeddable
public class EmployeeDepartmentHistoryPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "DepartmentID", nullable = false)
    private short departmentID;
    @Column(name = "ShiftID", nullable = false)
    private short shiftID;
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

}
